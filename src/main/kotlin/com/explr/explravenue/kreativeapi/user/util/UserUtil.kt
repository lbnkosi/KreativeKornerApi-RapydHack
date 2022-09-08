package com.explr.explravenue.kreativeapi.user.util

import com.explr.explravenue.kreativeapi.user.models.CreateUserRequest
import com.explr.explravenue.rapyd.collect.customer.create_customer.request.CreateCustomerRequest
import com.explr.explravenue.rapyd.collect.customer.create_customer.request.PaymentMethod
import com.explr.explravenue.rapyd.collect.customer.create_customer.response.CreateCustomerResponse
import com.explr.explravenue.rapyd.wallet.create_personal.request.Address
import com.explr.explravenue.rapyd.wallet.create_personal.request.Contact
import com.explr.explravenue.rapyd.wallet.create_personal.request.CreatePersonalWalletRequest
import com.explr.explravenue.rapyd.wallet.create_personal.response.CreatePersonalWalletResponse

object UserUtil {

    fun generateWalletRequest(request: CreateUserRequest): CreatePersonalWalletRequest {
        val walletRequest = CreatePersonalWalletRequest()
        walletRequest.first_name = request.name
        walletRequest.last_name = request.surname
        walletRequest.email = request.email
        walletRequest.ewallet_reference_id = request.email
        walletRequest.phone_number = request.phone
        walletRequest.type = "person"
        val walletContact = Contact()
        walletContact.phone_number = request.phone
        walletContact.email = request.email
        walletContact.first_name = request.name
        walletContact.last_name = request.surname
        walletContact.contact_type = "personal"
        walletContact.identification_type = "PA"
        walletContact.identification_number = request.phone.replace("+", "")
        walletContact.date_of_birth = "11/22/1999"
        walletContact.nationality = request.country
        walletContact.country = request.country
        val walletAddress = Address()
        walletAddress.name = request.name +" "+ request.surname
        walletAddress.line_1 = "123 Main Street"
        walletAddress.city = "Anytown"
        walletAddress.state = "NY"
        walletAddress.country = request.country
        walletAddress.zip = "12345"
        walletAddress.phone_number = request.phone
        walletContact.address = walletAddress
        walletRequest.contact = walletContact
        return walletRequest
    }

    fun generateCustomerRequest(request: CreateUserRequest, response: CreatePersonalWalletResponse): CreateCustomerRequest {
        val customerRequest = CreateCustomerRequest()
        customerRequest.name = request.name + " " + request.surname
        customerRequest.business_vat_id = request.phone
        customerRequest.email = request.email
        customerRequest.ewallet = response.data.id
        customerRequest.invoice_prefix = request.name + "- "
        customerRequest.phone_number = request.phone
        val paymentMethod = PaymentMethod()
        paymentMethod.type = "mx_visa_card"
        paymentMethod.fields.number = "4242424242424242"
        paymentMethod.fields.expiration_month = "01"
        paymentMethod.fields.expiration_year = "25"
        paymentMethod.fields.cvv = "123"
        customerRequest.payment_method = paymentMethod
        return customerRequest
    }

    fun generateFirebaseRequest(request: CreateUserRequest, walletResponse: CreatePersonalWalletResponse, customerResponse: CreateCustomerResponse): CreateUserRequest {
        request.ref_id = walletResponse.data.ewallet_reference_id
        request.wallet_id = walletResponse.data.id
        request.customer_id = customerResponse.data.id
        request.payment_method = customerResponse.data.default_payment_method
        return request
    }

}