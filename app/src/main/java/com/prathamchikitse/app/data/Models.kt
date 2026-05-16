package com.prathamchikitse.app.data

data class EmergencyStep(
    val stepNumber: Int,
    val instructionEn: String,
    val instructionKn: String
)

data class Emergency(
    val id: Int,
    val titleEn: String,
    val titleKn: String,
    val iconResName: String,
    val colorHex: String,
    val steps: List<EmergencyStep>,
    val dosEn: List<String> = emptyList(),
    val dosKn: List<String> = emptyList(),
    val dontsEn: List<String> = emptyList(),
    val dontsKn: List<String> = emptyList()
)

data class Hospital(
    val name: String,
    val distanceKm: Double,
    val phone: String,
    val address: String
)
