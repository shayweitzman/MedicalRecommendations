package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Treatments {
	private Map<Diseases, String> totalTreatment =new HashMap<Diseases, String>() {
		{
			put(Diseases.anemia,"Two 10 mg B12 pills a day for a month.");
			put(Diseases.diet, "Schedule an appointment with a nutritionist.");
			put(Diseases.bleeding, "Evacuate urgently to the hospital.");
			put(Diseases.Hyperlipidemia, "Arrange a meeting with a nutritionist \n\t5 mg pill of Simobil daily for a week.");
			put(Diseases.Disorder_of_blood_formation, " 10 mg pill of B12 per day for a month\n\t5 mg pill of folic acid a day for a month.");
			put(Diseases.Hematological_disorder, "Injection of a hormone to stimulate red blood cells production.");
			put(Diseases.Iron_poisoning, "Evacuate to the hospital.");
			put(Diseases.Dehydration, "Complete lying down rest\n\treturning fluids to drinking.");
			put(Diseases.Infection, "Dedicated antibiotics.");
			put(Diseases.Vitamin_deficiency, "Referral for a blood test to identify the missing vitamins.");
			put(Diseases.Viral_disease, "Rest at home.");
			put(Diseases.Diseases_of_the_biliary_tract, "Referral to surgical treatment.");
			put(Diseases.heart_diseases, "Schedule an appointment with a nutritionist.");
			put(Diseases.Blood_disease, "Combination of cyclophosphamide and corticosteroids.");
			put(Diseases.Liver_disease, "Referral to a specific diagnosis for treatment.");
			put(Diseases.Kidney_disease, "Balances blood sugar levels.");
			put(Diseases.Iron_deficiency, "two 10 mg B12 pills a day for a month.");
			put(Diseases.Muscle_diseases, "two 5 mg pills of Altman's c3 wrapper a day for a month.");
			put(Diseases.Smoker, "Quit smoking.");
			put(Diseases.Lung_disease, "Stop Smoking / Referral for X-ray of the lungs.");
			put(Diseases.Overactive_thyroid_gland, "Propylthiouracil to reduce the activity of the thyroid gland.");
			put(Diseases.Adult_diabetes, "Insulin adjustment for patient.");
			put(Diseases.cancer, "Entrectinib.");
			put(Diseases.Increased_consumption_of_meat, "Coordinate an appointment with a nutritionist.");
			put(Diseases.Use_of_various_medications, "Refer to the family doctor for a match between the medications.");
			put(Diseases.Malnutrition, "Coordinate an appointment with a nutritionist.");
		}
	};
	
	public Map<Diseases, String> personalTreatment=new HashMap<Diseases, String>() ;
	public Treatments(Map<Diseases, Integer> totalDiagnose)
	{
		for(Diseases d : totalDiagnose.keySet())
		{
			if (totalDiagnose.get(d) != 0)
				personalTreatment.put(d, totalTreatment.get(d));
		}

	}
}
