package cn.com.offcn.day05;

public enum GenderEnum {
    MALE("先生",1),
    FEMAE("女士",0);
    private String name;
    private int key;
    private GenderEnum(String name, int key) {
        this.name = name;
        this.key = key;
    }

//    public static GenderEnum findEnumByName(String name) {
//        for (GenderEnum statusEnum : GenderEnum.values()) {
//            if (statusEnum.getName().equals(name)) {
//                //如果需要直接返回code则更改返回类型为String,return statusEnum.code;
//                return statusEnum;
//            }
//        }
//        throw new IllegalArgumentException("name is invalid");
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
