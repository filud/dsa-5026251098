//package lw01.prelab;

public class ColourPrint extends PrintJob {
    public ColourPrint(String id, int pages) {
        super(id, pages);
    }
    
    public int calculateCharge() {
        //int pages = this.getPages();
        int first10 = Math.min(this.getPages(), 10);
        int beyond10 = Math.max(this.getPages() - 10, 0);
        return (first10 * 1500) + (beyond10 * 1000) + 2000;
    }
    
    public String label() {
        return "Colour";
    }
}
