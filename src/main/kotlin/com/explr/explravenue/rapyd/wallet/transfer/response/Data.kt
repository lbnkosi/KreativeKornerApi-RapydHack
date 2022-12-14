package com.explr.explravenue.rapyd.wallet.transfer.response

import com.explr.explravenue.rapyd.wallet.transfer.response.Metadata
import com.explr.explravenue.rapyd.wallet.transfer.response.ResponseMetadata

data class Data(
    var id: String = "",
    var status: String = "",
    var amount: Int = 0,
    var currency_code: String = "",
    var destination_phone_number: Any = Any(),
    var destination_ewallet_id: String = "",
    var destination_transaction_id: String = "",
    var source_ewallet_id: String = "",
    var source_transaction_id: String = "",
    var transfer_response_at: Int = 0,
    var created_at: Int = 0,
    var metadata: Metadata = Metadata(),
    var response_metadata: ResponseMetadata = ResponseMetadata()
)