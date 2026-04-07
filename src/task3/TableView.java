public class TableView extends ViewResult {
    private int width = 15;
    public TableView(int width) { this.width = width; }

    @Override
    public void viewHeader() {
        System.out.println("┌" + "─".repeat(width * 4 + 7) + "┐");
        System.out.printf("│ %-" + width + "s │ %-" + width + "s │ %-" + width + "s │ %-" + width + "s │\n", "Число", "Bin", "Oct", "Hex");
        System.out.println("├" + "─".repeat(width * 4 + 7) + "┤");
    }


    @Override
    public void viewData(CalculationResult i) {
        System.out.printf("│ %-" + width + "d │ %-" + width + "s │ %-" + width + "s │ %-" + width + "s │\n", 
                          i.number, i.binary, i.octal, i.hex);
    }

    @Override
    public void viewFooter() {
        System.out.println("└" + "─".repeat(width * 4 + 7) + "┘");
    }
}