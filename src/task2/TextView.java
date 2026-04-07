

public class TextView implements View {
    public void viewHeader() { System.out.println("===== ЗВІТ ОБЧИСЛЕНЬ ====="); }
    public void viewBody()   { System.out.println("Виведення даних з колекції:"); }
    public void viewFooter() { System.out.println("=========================="); }
    
    public void viewData(CalculationResult data) {
        System.out.println(data);
    }
}

class TextViewFactory implements ViewFactory {
    public View createView() {
        return new TextView();
    }
}