package com.explr.explravenue.kreativeapi.user.util

import com.explr.explravenue.kreativeapi.user.models.CreateUserRequest
import com.explr.explravenue.rapyd.collect.customer.create_customer.request.CreateCustomerRequest
import com.explr.explravenue.rapyd.collect.customer.create_customer.request.PaymentMethod
import com.explr.explravenue.rapyd.collect.customer.create_customer.response.CreateCustomerResponse
import com.explr.explravenue.rapyd.wallet.create_company.request.*
import com.explr.explravenue.rapyd.wallet.create_company.response.CreateCompanyWalletResponse

object UserUtil {

    fun generateWalletRequest(request: CreateUserRequest): CreateCompanyWalletRequest {
        val walletRequest = CreateCompanyWalletRequest()
        walletRequest.first_name = request.name + " " + request.surname
        walletRequest.ewallet_reference_id = request.email
        walletRequest.type = "company"
        val walletContact = Contact()
        walletContact.phone_number = request.phone
        walletContact.email = request.email
        walletContact.first_name = request.name
        walletContact.last_name = request.surname
        walletContact.contact_type = "business"
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
        val businessDetails = BusinessDetails()
        businessDetails.entity_type = "company"
        businessDetails.name = request.name + " " + request.surname
        businessDetails.registration_number = request.phone
        businessDetails.industry_category = "company"
        businessDetails.industry_sub_category = "social media"
        val companyAddress = AddressX()
        companyAddress.name = request.name +" "+ request.surname
        companyAddress.line_1 = "123 Main Street"
        companyAddress.city = "Anytown"
        companyAddress.state = "NY"
        companyAddress.country = request.country
        companyAddress.zip = "12345"
        companyAddress.phone_number = request.phone
        companyAddress.nationality = request.country
        businessDetails.address = companyAddress
        walletContact.business_details = businessDetails
        walletRequest.contact = walletContact
        return walletRequest
    }

    fun generateCustomerRequest(request: CreateUserRequest, response: CreateCompanyWalletResponse): CreateCustomerRequest {
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

    fun generateFirebaseRequest(request: CreateUserRequest, walletResponse: CreateCompanyWalletResponse, customerResponse: CreateCustomerResponse): CreateUserRequest {
        request.ref_id = walletResponse.data.ewallet_reference_id
        request.wallet_id = walletResponse.data.id
        request.customer_id = customerResponse.data.id
        request.payment_method = customerResponse.data.default_payment_method
        return request
    }

}