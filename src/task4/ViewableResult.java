public class ViewableResult implements Viewable {
    private boolean useTable;
    private int width;
    public ViewableResult(boolean useTable, int width) { this.useTable = useTable; this.width = width; }
    @Override public View getView() { return useTable ? new TableView(width) : new ViewResult(); }
}