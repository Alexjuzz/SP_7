package Spring.Hm7.logservice;

public interface LogWriter {
    void log(String nameUser,String methodName, String inputArgs,String returnedValues);

}
