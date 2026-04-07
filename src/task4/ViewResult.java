import java.io.*;
import java.util.ArrayList;

public class ViewResult implements View {
    protected ArrayList<CalculationResult> items = new ArrayList<>();

    @Override public void viewInit() { /* твоя логіка */ }
    @Override public void viewHeader() { System.out.println("--- Текст ---"); }
    @Override public void viewBody() { for(CalculationResult i : items) viewData(i); }
    @Override public void viewFooter() { System.out.println("-------------"); }
    @Override public void viewShow() { viewHeader(); viewBody(); viewFooter(); }
    @Override public void viewSave() throws IOException {}
    @Override public void viewRestore() throws Exception {}

    @Override
    public void viewData(CalculationResult data) {
        System.out.println(data);
    }
}