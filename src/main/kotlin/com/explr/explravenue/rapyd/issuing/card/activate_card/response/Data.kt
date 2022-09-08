package com.explr.explravenue.rapyd.issuing.card.activate_card.response

data class Data(
    var id: String = "",
    var ewallet_contact: EwalletContact = EwalletContact(),
    var status: String = "",
    var card_id: String = "",
    var assigned_at: Int = 0,
    var activated_at: Int = 0,
    var metadata: MetadataXX = MetadataXX(),
    var country_iso_alpha_2: String = "",
    var created_at: Int = 0,
    var blocked_reason: String = "",
    var card_tracking_id: Any = Any(),
    var card_program: String = "",
    var public_details: PublicDetails = PublicDetails()
)