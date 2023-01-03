package hw.homework.persondata.utils;

public class StackTraceViewer {
    public StackTraceElement[] getStackTrace(){
        return Thread.currentThread().getStackTrace();
    }

    public StackTraceElement getLastStackTrace(){
        return Thread.currentThread().getStackTrace()[0];
    }
}
