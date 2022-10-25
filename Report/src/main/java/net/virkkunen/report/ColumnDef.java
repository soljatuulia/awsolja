
package net.virkkunen.report;

/**
 *
 * @author Solja
 */
public class ColumnDef {
    
    private String title = "";
    private int width = 0;
    
    public ColumnDef(String title, int width) {
        this.title = title;
        this.width = width;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
}
