class EagerLogger { 
    //#1 부지런한 초기화
    private static uniqueObject : EagerLogger = new EagerLogger();

    //#2 private 을 붙여 객체로 생성되지 않도록 함. 
    private EagerLogger() {}

    //#3 static을 붙여 외부 접근을 가능케 함. 
    public static getLogger() : EagerLogger {
        return this.uniqueObject;
    }

    


}