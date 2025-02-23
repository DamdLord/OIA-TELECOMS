package com.example.oiatelecoms.data


object NetworkList{
    val networkList = listOf("Select Network","MTN", "AIRTEL", "9MOBILE", "GLO")

}

object AirtimeType{
    val airtimeTypeList = listOf("VTU", "Share and sell")
}

object DataType{
    val MTNDataTypeList = listOf("select type", "SME", "Gifting", "Corporate")
    val AirtelDataType = listOf("Select Type", "Gifting", "Corporate")
    val GLODtaType = listOf("Select Type", "Corporate")
    val NineMobileDtaType = listOf("Select Type", "SME", "Corporate")
}
object DataPlan{
    val dataPlanList = listOf("select plan", "", "")
}
object MeterType{
    val meterTypeList = listOf("Select type", "Prepaid", "Postpaid")
}

object DataPlanList{
    val mtnSME = listOf(
        "Select Plan",
        "500MB SME (₦142)(30 DAYS)",
        "1GB SME (₦261)(30 DAYS)",
        "2GB SME (₦526)(30 DAYS)",
        "3GB SME (₦790)(30 DAYS)",
        "5GB SME (₦1315)(30 DAYS)",
        "10GB SME (₦2605)(30 DAYS)",
        "500MB SME (₦139)(30 DAYS)"
    )
    val mtnGifting = listOf(
        "Select Plan",
        "SME2 500MB Gifting (₦129)(30 DAYS)",
        "SME2 50MB Gifting (₦30)(30 DAYS)",
        "SME2 1GB Gifting (₦225)(30 DAYS)",
        "SME2 2GB Gifting (₦510)(30 DAYS)",
        "SME2 7GB Gifting (₦1785)(30 DAYS)",
        "SME2 6GB Gifting (₦1530)(30 DAYS)",
        "SME2 2.5GB Gifting (₦639)(30 DAYS)",
        "SME2 25MB Gifting (₦24)(30 DAYS)",
        "SME2 20MB Gifting (₦20)(30 DAYS)",
        "SME2 100MB Gifting (₦65)(30 DAYS)",
        "SME2 1.5GB Gifting (₦384)(30 DAYS)",
        "SME2 10GB Gifting (₦2250)(30 DAYS)",
        "SME2 5GB Gifting (₦1275)(30 DAYS)",
        "SME2 3GB Gifting (₦765)(30 DAYS)"
    )

    val ntnCorporate = listOf(
        "Select Plan",
        "500MB Corporate (₦135)(30 DAYS)",
        "1GB Corporate (₦265)(30 DAYS)",
        "2GB Corporate (₦532)(30 DAYS)",
        "5GB Corporate (₦1327)(30 DAYS)",
        "10GB Corporate (₦2652)(30 DAYS)",
        "20GB Corporate (₦5222)(30 DAYS)",
        "150MB Corporate (₦65)(30 DAYS)",
        "250MB Corporate (₦85)(30 DAYS)",
        "15GB Corporate (₦3915)(30 DAYS)",
        "12GB Corporate (₦3132)(30 DAYS)",
        "40GB Corporate (₦10440)(30 DAYS)",
        "75GB Corporate (₦19575)(30 DAYS)",
        "100GB Corporate (₦26100)(30 DAYS)"
    )
    val airtelGifting = listOf(
        "Select Plan",
        "20GB Gifting (₦4600)(30 DAYS)",
        "40GB Gifting (₦8800)(30 DAYS)",
        "75GB Gifting (₦13375)(30 DAYS)",
        "120GB Gifting (₦19000)(30 DAYS)",
        "1.5GB Gifting (₦900)(30 DAYS)",
        "2GB Gifting (₦1100)(30 DAYS)",
        "10GB Gifting (₦2800)(30 DAYS)",
        "11GB Gifting (₦3700)(30 DAYS)",
        "6GB Gifting (₦2250)(30 DAYS)"
    )
    val airtelCorporate = listOf(
        "Select Plan",
        "500MB Corporate (₦148)(30 DAYS)",
        "1GB Corporate (₦282)(30 DAYS)",
        "2GB Corporate (₦556)(30 DAYS)",
        "5GB Corporate (₦1390)(30 DAYS)",
        "10GB Corporate (₦2782)(30 DAYS)",
        "300MB Corporate (₦124)(7 DAYS)",
        "300MB Corporate (₦100)(30 DAYS)",
        "20GB Corporate (₦5440)(30 DAYS)",
        "15GB Corporate (₦4080)(30 DAYS)"
    )
    val gloCorporate = listOf(
        "Select Plan",
        "200MB Corporate (₦77)(30 DAYS)",
        "500MB Corporate (₦142)(30 DAYS)",
        "1GB Corporate (₦277)(30 DAYS)",
        "2GB Corporate (₦552)(30 DAYS)",
        "3GB Corporate (₦826)(30 DAYS)",
        "5GB Corporate (₦1376)(30 DAYS)",
        "10GB Corporate (₦2752)(30 DAYS)"
    )
    val nineMobileSME = listOf(
        "Select Plan",
        "1GB SME (₦220)(30 DAYS)",
        "3GB SME (₦660)(30 DAYS)"
    )
    val nineMobileCorporate = listOf(
        "Select Plan",
        "1GB Corporate (₦150)(30 DAYS)",
        "2GB Corporate (₦292)(30 DAYS)",
        "3GB Corporate (₦436)(30 DAYS)",
        "5GB Corporate (₦726)(30 DAYS)"

    )
}

object CableTvProviderServiceList{
    val GOTVServiceList = listOf(
        "GOTV LITE/₦1575/MONTH",
        "GOTV JINJA/₦3300/MONTH",
        "GOTV JOLLI/₦4850/MONTH",
        "GOTV MAX/₦7200/MONTH",
        "GOTV SUPA/₦9600/MONTH",
        "GOTV SUPA PLUS/₦15700/MONTH"
    )
    val DSTVServiceList = listOf(
        "DSTV PADI/₦3600/MONTH",
        "DSTV YANGA/₦5100/MONTH",
        "DSTV CONFAM/₦9300/MONTH",
        "DSTV COMPACT/₦15700/MONTH",
        "DSTV COMPACT PLUS/₦25000/MONTH",
        "DSTV COMPACT PLUS+XtraView/₦30000/MONTH"
    )
    val STARTIMESServiceList = listOf(
        "DTH NOVA/₦1900/MONTH",
        "DTT NOVA/₦1900/MONTH",
        "DTT BASIC/₦3700/MONTH",
        "DTH BASIC/₦4700/MONTH",
        "DTT CLASSIC/₦5500/MONTH"
    )
}

object CableTvProvider{
    val providerList = listOf("Select Provider", "GOTV", "DSTV", "STARTIMES")
}

object SubscriptionType{
    val subscriptionTypeList = listOf("Subscription type", "Change", "Renew")
}
object Discos{
    val discosProviderList = listOf("Select Disco", "ABUJA ELECTRICITY", "EKO ELECTRICITY",
        "KADUNA ELECTRICITY", "KANO ELECTRICITY", "JOS ELECTRICITY",
        "IKEJA ELECTRICITY", "IBADAN ELECTRICITY", "PORT HARCOURT ELECTRICITY", "BENIN ELECTRICITY", "YOLA ELECTRICITY"
    )
}



object DataTypeForDataPins{
    val dataTypeList = listOf("Select type", "SME", "Gifting", "Corporate")
}

object ExamType{
    val examTypeList = listOf("Select type", "WAEC", "NECO", "NABTEB")
}
object States{
    val  listOfStates = listOf(
        "State", "Abuja FCT","Abia", "Adamawa", "Akwa Ibom", "Anambra", "Bauchi", "Bayelsa", "Benue", "Borno", "Cross River", "Delta", "Ebonyi",
        "Edo", "Ekiti", "Enugu", "Gombe", "Imo", "Jigawa", "Kaduna", "Kano", "Kastina", "Kebbi", "Kogi", "Kwara", "Lagos", "Nassarawa", "Niger",
        "Ogun", "Ondo", "Osun", "Oyo", "Plateau", "Rivers", "Sokoto", "Taraba", "Yobe", "Zamfara"
    )
}

