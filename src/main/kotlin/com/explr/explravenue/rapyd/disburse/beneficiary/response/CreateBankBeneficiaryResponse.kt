package com.explr.explravenue.rapyd.disburse.beneficiary.response

data class CreateBankBeneficiaryResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)