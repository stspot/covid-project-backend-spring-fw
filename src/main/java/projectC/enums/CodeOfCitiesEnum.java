package projectC.enums;

//TODO Documentation
public enum CodeOfCitiesEnum {

	BLG_ALL("", "Благоевград"),
	BLG_ACT("", "Благоевград"),
	BGS_ALL("", "Бургас"),
	BGS_ACT("", "Бургас"),
	VAR_ALL("", "Варна"),
	VAR_ACT("", "Варна"),
	VTR_ALL("", "Велико Тървоно"),
	VTR_ACT("", "Велико Тървоно"),
	VID_ALL("", "Видин"),
	VID_ACT("", "Видин"),
	VRC_ALL("", "Враца"),
	VRC_ACT("", "Враца"),
	GAB_ALL("", "Габрово"),
	GAB_ACT("", "Габрово"),
	DOB_ALL("", "Добрич"),
	DOB_ACT("", "Добрич"),
	KRZ_ALL("", "Кърджали"),
	KRZ_ACT("", "Кърджали"),
	KNL_ALL("", "Кюстендил"),
	KNL_ACT("", "Кюстендил"),
	LOV_ALL("", "Ловеч"),
	LOV_ACT("", "Ловеч"),
	MON_ALL("", "Монтана"),
	MON_ACT("", "Монтана"),
	PAZ_ALL("", "Пазарджик"),
	PAZ_ACT("", "Пазарджик"),
	PER_ALL("", "Перник"),
	PER_ACT("", "Перник"),
	PVN_ALL("", "Плевен"),
	PVN_ACT("", "Плевен"),
	PDV_ALL("", "Пловдив"),
	PDV_ACT("", "Пловдив"),
	RAZ_ALL("", "Разград"),
	RAZ_ACT("", "Разград"),
	RSE_ALL("", "Русе"),
	RSE_ACT("", "Русе"),
	SLS_ALL("", "Силистра"),
	SLS_ACT("", "Силистра"),
	SLV_ALL("", "Сливен"),
	SLV_ACT("", "Сливен"),
	SML_ALL("", "Смолян"),
	SML_ACT("", "Смолян"),
	SFO_ALL("", "София област"),
	SFO_ACT("", "София област"),
	SOF_ALL("", "София град"),
	SOF_ACT("", "София град"),
	SZR_ALL("", "Стара Загора"),
	SZR_ACT("", "Стара Загора"),
	TGV_ALL("", "Търговище"),
	TGV_ACT("", "Търговище"),
	HKV_ALL("", "Хасково"),
	HKV_ACT("", "Хасково"),
	SHU_ALL("", "Шумен"),
	SHU_ACT("", "Шумен"),
	JAM_ALL("", "Ямбол"),
	JAM_ACT("", "Ямбол");
	
	private String nameEn;
	private String nameBg;
	
	private CodeOfCitiesEnum(String nameEn, String nameBg) {
		this.nameEn = nameEn;
		this.nameBg = nameBg;
	}

	public String getNameEn() {
		return nameEn;
	}

	public String getNameBg() {
		return nameBg;
	}
}
