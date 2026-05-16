package com.prathamchikitse.app.data

object EmergencyRepository {
    fun getEmergencies(): List<Emergency> {
        return listOf(
            Emergency(
                id = 1,
                titleEn = "Snake Bite",
                titleKn = "ಹಾವು ಕಡಿತ",
                iconResName = "ic_snake_bite", // Drawable resource name
                colorHex = "#FF5252",
                steps = listOf(
                    EmergencyStep(1, "Keep the patient calm and still. Movement spreads the venom.", "ರೋಗಿಯನ್ನು ಶಾಂತವಾಗಿ ಮತ್ತು ಅಲುಗಾಡದಂತೆ ಇರಿಸಿ. ಚಲನೆಯು ವಿಷವನ್ನು ಹರಡುತ್ತದೆ."),
                    EmergencyStep(2, "Remove tight clothing and jewelry near the bite.", "ಕಡಿತದ ಸಮೀಪವಿರುವ ಬಿಗಿಯಾದ ಬಟ್ಟೆ ಮತ್ತು ಆಭರಣಗಳನ್ನು ತೆಗೆದುಹಾಕಿ."),
                    EmergencyStep(3, "Keep the bitten area below the level of the heart.", "ಕಚ್ಚಿದ ಭಾಗವನ್ನು ಹೃದಯದ ಮಟ್ಟಕ್ಕಿಂತ ಕೆಳಗೆ ಇರಿಸಿ.")
                ),
                dosEn = listOf("Seek immediate medical help", "Keep the limb immobilized"),
                dosKn = listOf("ತಕ್ಷಣದ ವೈದ್ಯಕೀಯ ಸಹಾಯ ಪಡೆಯಿರಿ", "ಕೈ/ಕಾಲನ್ನು ಅಲುಗಾಡಿಸದಂತೆ ಇರಿಸಿ"),
                dontsEn = listOf("Do NOT try to suck the venom out", "Do NOT apply a tourniquet"),
                dontsKn = listOf("ವಿಷವನ್ನು ಹೀರಲು ಪ್ರಯತ್ನಿಸಬೇಡಿ", "ಟೂರ್ನಿಕೆಟ್ (ಬಿಗಿಯಾದ ಪಟ್ಟಿ) ಕಟ್ಟಬೇಡಿ")
            ),
            Emergency(
                id = 2,
                titleEn = "Choking",
                titleKn = "ಉಸಿರುಗಟ್ಟುವಿಕೆ",
                iconResName = "ic_choking",
                colorHex = "#FF9800",
                steps = listOf(
                    EmergencyStep(1, "Stand behind the person and wrap your arms around their waist.", "ವ್ಯಕ್ತಿಯ ಹಿಂದೆ ನಿಂತು ಅವರ ಸೊಂಟದ ಸುತ್ತ ನಿಮ್ಮ ತೋಳುಗಳನ್ನು ಸುತ್ತಿಕೊಳ್ಳಿ."),
                    EmergencyStep(2, "Make a fist with one hand and place it just above their belly button.", "ಒಂದು ಕೈಯಿಂದ ಮುಷ್ಟಿ ಮಾಡಿ ಮತ್ತು ಅದನ್ನು ಅವರ ಹೊಕ್ಕುಳಿನ ಸ್ವಲ್ಪ ಮೇಲ್ಭಾಗದಲ್ಲಿ ಇರಿಸಿ."),
                    EmergencyStep(3, "Grab your fist with the other hand and perform quick upward thrusts.", "ನಿಮ್ಮ ಮುಷ್ಟಿಯನ್ನು ಇನ್ನೊಂದು ಕೈಯಿಂದ ಹಿಡಿದು ತ್ವರಿತವಾಗಿ ಮೇಲ್ಮುಖವಾಗಿ ಒತ್ತಿರಿ.")
                )
            ),
            Emergency(
                id = 3,
                titleEn = "Burns",
                titleKn = "ಸುಟ್ಟ ಗಾಯಗಳು",
                iconResName = "ic_burns",
                colorHex = "#FFC107",
                steps = listOf(
                    EmergencyStep(1, "Cool the burn with cool (not cold) running water for 10-15 minutes.", "ಸುಟ್ಟ ಗಾಯವನ್ನು 10-15 ನಿಮಿಷಗಳ ಕಾಲ ತಣ್ಣನೆಯ (ಅತಿ ತಣ್ಣಗಿಲ್ಲದ) ಹರಿಯುವ ನೀರಿನಲ್ಲಿ ತಂಪಾಗಿಸಿ."),
                    EmergencyStep(2, "Cover the burn loosely with a sterile, non-fluffy dressing or cloth.", "ಕ್ರಿಮಿನಾಶಕ, ನಯವಾದ ಬ್ಯಾಂಡೇಜ್ ಅಥವಾ ಬಟ್ಟೆಯಿಂದ ಗಾಯವನ್ನು ಸಡಿಲವಾಗಿ ಮುಚ್ಚಿ.")
                ),
                dontsEn = listOf("Do NOT apply ice", "Do NOT pop blisters", "Do NOT apply butter or ointments"),
                dontsKn = listOf("ಮಂಜುಗಡ್ಡೆ ಹಚ್ಚಬೇಡಿ", "ಗುಳ್ಳೆಗಳನ್ನು ಒಡೆಯಬೇಡಿ", "ಬೆಣ್ಣೆ ಅಥವಾ ಮುಲಾಮುಗಳನ್ನು ಹಚ್ಚಬೇಡಿ")
            ),
            Emergency(
                id = 4,
                titleEn = "Heart Attack",
                titleKn = "ಹೃದಯಾಘಾತ",
                iconResName = "ic_heart_attack",
                colorHex = "#F44336",
                steps = listOf(
                    EmergencyStep(1, "Call for emergency medical help immediately.", "ತಕ್ಷಣ ತುರ್ತು ವೈದ್ಯಕೀಯ ಸಹಾಯಕ್ಕಾಗಿ ಕರೆ ಮಾಡಿ."),
                    EmergencyStep(2, "Have the person sit down, rest, and try to keep calm.", "ವ್ಯಕ್ತಿಯನ್ನು ಕುಳಿತುಕೊಳ್ಳಲು, ವಿಶ್ರಾಂತಿ ಪಡೆಯಲು ಮತ್ತು ಶಾಂತವಾಗಿರಲು ಹೇಳಿ."),
                    EmergencyStep(3, "Loosen any tight clothing.", "ಯಾವುದೇ ಬಿಗಿಯಾದ ಬಟ್ಟೆಗಳನ್ನು ಸಡಿಲಗೊಳಿಸಿ.")
                )
            ),
            Emergency(
                id = 5,
                titleEn = "Fracture",
                titleKn = "ಮೂಳೆ ಮುರಿತ",
                iconResName = "ic_fracture",
                colorHex = "#90A4AE",
                steps = listOf(
                    EmergencyStep(1, "Do not move the person unless necessary.", "ಅಗತ್ಯವಿಲ್ಲದಿದ್ದರೆ ವ್ಯಕ್ತಿಯನ್ನು ಚಲಿಸಬೇಡಿ."),
                    EmergencyStep(2, "Support the injured area with a splint.", "ಗಾಯಗೊಂಡ ಭಾಗಕ್ಕೆ ಸ್ಪ್ಲಿಂಟ್‌ನೊಂದಿಗೆ ಬೆಂಬಲ ನೀಡಿ.")
                )
            ),
            Emergency(
                id = 6,
                titleEn = "Severe Bleeding",
                titleKn = "ತೀವ್ರ ರಕ್ತಸ್ರಾವ",
                iconResName = "ic_bleeding",
                colorHex = "#D32F2F",
                steps = listOf(
                    EmergencyStep(1, "Apply direct pressure with a clean cloth.", "ಶುದ್ಧವಾದ ಬಟ್ಟೆಯಿಂದ ನೇರ ಒತ್ತಡವನ್ನು ಹಾಕಿ."),
                    EmergencyStep(2, "Elevate the wound above heart level.", "ಗಾಯವನ್ನು ಹೃದಯದ ಮಟ್ಟಕ್ಕಿಂತ ಎತ್ತರಕ್ಕೆ ಏರಿಸಿ.")
                )
            ),
            Emergency(
                id = 7,
                titleEn = "Fainting",
                titleKn = "ಮೂರ್ಛೆ ತಪ್ಪುವುದು",
                iconResName = "ic_fainting",
                colorHex = "#4DB6AC",
                steps = listOf(
                    EmergencyStep(1, "Lay the person on their back and elevate legs.", "ವ್ಯಕ್ತಿಯನ್ನು ಬೆನ್ನಿನ ಮೇಲೆ ಮಲಗಿಸಿ ಮತ್ತು ಕಾಲುಗಳನ್ನು ಎತ್ತರಿಸಿ."),
                    EmergencyStep(2, "Check for breathing and loosen tight clothing.", "ಉಸಿರಾಟವನ್ನು ಪರೀಕ್ಷಿಸಿ ಮತ್ತು ಬಿಗಿಯಾದ ಬಟ್ಟೆಗಳನ್ನು ಸಡಿಲಗೊಳಿಸಿ.")
                )
            ),
            Emergency(
                id = 8,
                titleEn = "Electric Shock",
                titleKn = "ವಿದ್ಯುತ್ ಆಘಾತ",
                iconResName = "ic_electric_shock",
                colorHex = "#FDD835",
                steps = listOf(
                    EmergencyStep(1, "Turn off the source of electricity.", "ವಿದ್ಯುತ್ ಮೂಲವನ್ನು ಆಫ್ ಮಾಡಿ."),
                    EmergencyStep(2, "Do not touch the person with bare hands.", "ವ್ಯಕ್ತಿಯನ್ನು ಬರಿಗೈಯಿಂದ ಮುಟ್ಟಬೇಡಿ.")
                )
            ),
            Emergency(
                id = 9,
                titleEn = "Poisoning",
                titleKn = "ವಿಷಪೂರಿತ",
                iconResName = "ic_poisoning",
                colorHex = "#8E24AA",
                steps = listOf(
                    EmergencyStep(1, "Try to identify the poison.", "ವಿಷವನ್ನು ಗುರುತಿಸಲು ಪ್ರಯತ್ನಿಸಿ."),
                    EmergencyStep(2, "Do not induce vomiting unless told by a professional.", "ವೃತ್ತಿಪರರು ಹೇಳದ ಹೊರತು ವಾಂತಿ ಮಾಡಿಸಬೇಡಿ.")
                )
            ),
            Emergency(
                id = 10,
                titleEn = "Dog Bite",
                titleKn = "ನಾಯಿ ಕಡಿತ",
                iconResName = "ic_dog_bite",
                colorHex = "#795548",
                steps = listOf(
                    EmergencyStep(1, "Wash the wound with soap and water for 15 minutes.", "ಗಾಯವನ್ನು 15 ನಿಮಿಷಗಳ ಕಾಲ ಸೋಪು ಮತ್ತು ನೀರಿನಿಂದ ತೊಳೆಯಿರಿ."),
                    EmergencyStep(2, "Apply an antiseptic and see a doctor for rabies vaccine.", "ನಂಜುನಿರೋಧಕವನ್ನು ಹಚ್ಚಿ ಮತ್ತು ರೇಬಿಸ್ ಲಸಿಕೆಗಾಗಿ ವೈದ್ಯರನ್ನು ಭೇಟಿ ಮಾಡಿ.")
                )
            ),
            Emergency(
                id = 11,
                titleEn = "Heat Stroke",
                titleKn = "ಬಿಸಿಲು ಹೊಡೆತ",
                iconResName = "ic_heat_stroke",
                colorHex = "#FF5722",
                steps = listOf(
                    EmergencyStep(1, "Move the person to a cool place.", "ವ್ಯಕ್ತಿಯನ್ನು ತಂಪಾದ ಸ್ಥಳಕ್ಕೆ ಸರಿಸಿ."),
                    EmergencyStep(2, "Cool the body with wet cloths or a cool bath.", "ಒದ್ದೆ ಬಟ್ಟೆ ಅಥವಾ ತಣ್ಣನೆಯ ಸ್ನಾನದ ಮೂಲಕ ದೇಹವನ್ನು ತಂಪಾಗಿಸಿ.")
                )
            ),
            Emergency(
                id = 12,
                titleEn = "Drowning",
                titleKn = "ನೀರಿನಲ್ಲಿ ಮುಳುಗುವುದು",
                iconResName = "ic_drowning",
                colorHex = "#0288D1",
                steps = listOf(
                    EmergencyStep(1, "Get the person out of the water safely.", "ವ್ಯಕ್ತಿಯನ್ನು ಸುರಕ್ಷಿತವಾಗಿ ನೀರಿನಿಂದ ಹೊರಗೆ ತನ್ನಿ."),
                    EmergencyStep(2, "Check for breathing and start CPR if necessary.", "ಉಸಿರಾಟವನ್ನು ಪರೀಕ್ಷಿಸಿ ಮತ್ತು ಅಗತ್ಯವಿದ್ದರೆ ಸಿಪಿಆರ್ ಪ್ರಾರಂಭಿಸಿ.")
                )
            ),
            Emergency(
                id = 13,
                titleEn = "Asthma Attack",
                titleKn = "ಉಬ್ಬಸದ ಆಕ್ರಮಣ",
                iconResName = "ic_asthma",
                colorHex = "#26C6DA",
                steps = listOf(
                    EmergencyStep(1, "Help the person sit up straight and keep them calm.", "ವ್ಯಕ್ತಿಯನ್ನು ನೆಟ್ಟಗೆ ಕೂರಿಸಿ ಮತ್ತು ಶಾಂತವಾಗಿರಲು ಸಹಾಯ ಮಾಡಿ."),
                    EmergencyStep(2, "Help them use their inhaler if they have one.", "ಅವರು ಇನ್‌ಹೇಲರ್ ಹೊಂದಿದ್ದರೆ ಅದನ್ನು ಬಳಸಲು ಸಹಾಯ ಮಾಡಿ.")
                )
            ),
            Emergency(
                id = 14,
                titleEn = "Nosebleed",
                titleKn = "ಮೂಗಿನ ರಕ್ತಸ್ರಾವ",
                iconResName = "ic_nosebleed",
                colorHex = "#EF5350",
                steps = listOf(
                    EmergencyStep(1, "Have the person sit up and lean slightly forward.", "ವ್ಯಕ್ತಿಯನ್ನು ಕೂರಿಸಿ ಮತ್ತು ಸ್ವಲ್ಪ ಮುಂದಕ್ಕೆ ಬಾಗಲು ಹೇಳಿ."),
                    EmergencyStep(2, "Pinch the soft part of the nose for 10-15 minutes.", "ಮೂಗಿನ ಮೃದುವಾದ ಭಾಗವನ್ನು 10-15 ನಿಮಿಷಗಳ ಕಾಲ ಹಿಡಿದುಕೊಳ್ಳಿ.")
                )
            ),
            Emergency(
                id = 15,
                titleEn = "Seizures",
                titleKn = "ಮೂರ್ಛೆ ರೋಗ",
                iconResName = "ic_seizure",
                colorHex = "#AB47BC",
                steps = listOf(
                    EmergencyStep(1, "Clear the area of hard or sharp objects.", "ಕಠಿಣ ಅಥವಾ ಚೂಪಾದ ವಸ್ತುಗಳನ್ನು ಅಲ್ಲಿಂದ ತೆರವುಗೊಳಿಸಿ."),
                    EmergencyStep(2, "Cushion their head and gently turn them onto one side.", "ಅವರ ತಲೆಗೆ ಮೆತ್ತೆಯ ಆಧಾರ ನೀಡಿ ಮತ್ತು ನಿಧಾನವಾಗಿ ಒಂದು ಬದಿಗೆ ತಿರುಗಿಸಿ.")
                )
            ),
            Emergency(
                id = 16,
                titleEn = "Head Injury",
                titleKn = "ತಲೆಗೆ ಪೆಟ್ಟು",
                iconResName = "ic_head_injury",
                colorHex = "#7E57C2",
                steps = listOf(
                    EmergencyStep(1, "Apply a cold pack to the injured area to reduce swelling.", "ಊತವನ್ನು ಕಡಿಮೆ ಮಾಡಲು ಗಾಯಗೊಂಡ ಭಾಗಕ್ಕೆ ಕೋಲ್ಡ್ ಪ್ಯಾಕ್ ಅನ್ವಯಿಸಿ."),
                    EmergencyStep(2, "Watch for confusion, vomiting, or loss of consciousness.", "ಗೊಂದಲ, ವಾಂತಿ ಅಥವಾ ಪ್ರಜ್ಞೆ ಕಳೆದುಕೊಳ್ಳುವ ಲಕ್ಷಣಗಳಿವೆಯೇ ಎಂದು ಗಮನಿಸಿ.")
                )
            ),
            Emergency(
                id = 17,
                titleEn = "Stroke",
                titleKn = "ಪಾರ್ಶ್ವವಾಯು",
                iconResName = "ic_stroke",
                colorHex = "#607D8B",
                steps = listOf(
                    EmergencyStep(1, "Check FAST: Face drooping, Arm weakness, Speech difficulty, Time to call help.", "FAST ಪರೀಕ್ಷಿಸಿ: ಮುಖ ಇಳಿಜಾರು, ತೋಳಿನ ದೌರ್ಬಲ್ಯ, ಮಾತಿನ ತೊಂದರೆ, ತಕ್ಷಣದ ನೆರವು."),
                    EmergencyStep(2, "Keep the person calm and lying on their side.", "ವ್ಯಕ್ತಿಯನ್ನು ಶಾಂತವಾಗಿರಿಸಿ ಮತ್ತು ಒಂದು ಬದಿಗೆ ಮಲಗಿಸಿ.")
                ),
                dosEn = listOf("Call 108 immediately", "Note the time symptoms started"),
                dosKn = listOf("ತಕ್ಷಣ 108 ಗೆ ಕರೆ ಮಾಡಿ", "ಲಕ್ಷಣಗಳು ಪ್ರಾರಂಭವಾದ ಸಮಯವನ್ನು ಗಮನಿಸಿ"),
                dontsEn = listOf("Do NOT give food or drink", "Do NOT give aspirin"),
                dontsKn = listOf("ಆಹಾರ ಅಥವಾ ಪಾನೀಯ ನೀಡಬೇಡಿ", "ಆಸ್ಪಿರಿನ್ ಮಾತ್ರೆ ನೀಡಬೇಡಿ")
            ),
            Emergency(
                id = 18,
                titleEn = "Allergic Reaction",
                titleKn = "ಅಲರ್ಜಿ ಪ್ರತಿಕ್ರಿಯೆ",
                iconResName = "ic_allergy",
                colorHex = "#FF4081",
                steps = listOf(
                    EmergencyStep(1, "Remove the person from the cause of allergy.", "ಅಲರ್ಜಿಗೆ ಕಾರಣವಾದ ಮೂಲದಿಂದ ವ್ಯಕ್ತಿಯನ್ನು ದೂರ ಸರಿಸಿ."),
                    EmergencyStep(2, "Help them use an EpiPen if available.", "ಎಪಿಪೆನ್ (EpiPen) ಲಭ್ಯವಿದ್ದರೆ ಅದನ್ನು ಬಳಸಲು ಸಹಾಯ ಮಾಡಿ.")
                ),
                dosEn = listOf("Call for help if breathing is difficult", "Keep the person lying flat"),
                dosKn = listOf("ಉಸಿರಾಟ ಕಷ್ಟವಾಗಿದ್ದರೆ ಸಹಾಯಕ್ಕಾಗಿ ಕರೆ ಮಾಡಿ", "ವ್ಯಕ್ತಿಯನ್ನು ಸಮತಟ್ಟಾಗಿ ಮಲಗಿಸಿ"),
                dontsEn = listOf("Do NOT ignore mild symptoms that worsen"),
                dontsKn = listOf("ಉಲ್ಬಣಗೊಳ್ಳುವ ಸಣ್ಣ ಲಕ್ಷಣಗಳನ್ನು ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ")
            ),
            Emergency(
                id = 19,
                titleEn = "Hypoglycemia",
                titleKn = "ಕಡಿಮೆ ಸಕ್ಕರೆ ಅಂಶ",
                iconResName = "ic_hypoglycemia",
                colorHex = "#00BCD4",
                steps = listOf(
                    EmergencyStep(1, "Give sugar, fruit juice, or candy immediately.", "ತಕ್ಷಣ ಸಕ್ಕರೆ, ಹಣ್ಣಿನ ರಸ ಅಥವಾ ಮಿಠಾಯಿ ನೀಡಿ."),
                    EmergencyStep(2, "If unconscious, do not give anything by mouth.", "ಅವರು ಪ್ರಜ್ಞಾಹೀನರಾಗಿದ್ದರೆ, ಬಾಯಿಯ ಮೂಲಕ ಏನನ್ನೂ ನೀಡಬೇಡಿ.")
                ),
                dosEn = listOf("Monitor for improvement", "Seek help if symptoms persist"),
                dosKn = listOf("ಸುಧಾರಣೆಯನ್ನು ಗಮನಿಸಿ", "ಲಕ್ಷಣಗಳು ಮುಂದುವರಿದರೆ ಸಹಾಯ ಪಡೆಯಿರಿ")
            ),
            Emergency(
                id = 20,
                titleEn = "Eye Injury",
                titleKn = "ಕಣ್ಣಿನ ಗಾಯ",
                iconResName = "ic_eye_injury",
                colorHex = "#3F51B5",
                steps = listOf(
                    EmergencyStep(1, "Do not rub or apply pressure to the eye.", "ಕಣ್ಣನ್ನು ಉಜ್ಜಬೇಡಿ ಅಥವಾ ಒತ್ತಡ ಹಾಕಬೇಡಿ."),
                    EmergencyStep(2, "Flush with clean water gently if a chemical is involved.", "ರಸಾಯನಿಕ ತಗುಲಿದ್ದರೆ ನಿಧಾನವಾಗಿ ಶುದ್ಧ ನೀರಿನಿಂದ ತೊಳೆಯಿರಿ.")
                ),
                dosEn = listOf("Cover the eye with a shield or cup", "Seek medical attention"),
                dosKn = listOf("ಕಣ್ಣನ್ನು ಕಪ್ ಅಥವಾ ರಕ್ಷಣಾ ಕವಚದಿಂದ ಮುಚ್ಚಿ", "ವೈದ್ಯಕೀಯ ನೆರವು ಪಡೆಯಿರಿ"),
                dontsEn = listOf("Do NOT try to remove embedded objects"),
                dontsKn = listOf("ಚುಚ್ಚಿದ ವಸ್ತುಗಳನ್ನು ತೆಗೆಯಲು ಪ್ರಯತ್ನಿಸಬೇಡಿ")
            )
        )
    }

    fun getHospitals(): List<Hospital> {
        return listOf(
            Hospital("District General Hospital", 2.5, "+91-800-1234567", "Main Road, Hubli"),
            Hospital("Sanjeevini Clinic", 5.0, "+91-800-7654321", "Market Street, Dharwad"),
            Hospital("LifeCare Emergency Center", 12.4, "+91-800-1112222", "Highway Junction, Belagavi")
        )
    }
}
