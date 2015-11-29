public class Comp249Assignment3Part1 {

    public static void main(String[] args) {
        CellList myCellList1 = new CellList();
        CellPhone cellPhone1 = new CellPhone(10000, 25.99, 2012, "Apple");
        CellPhone cellPhone2 = new CellPhone(10001, 22.99, 2015, "Microsoft");
        CellPhone cellPhone3 = new CellPhone(10002, 26.99, 2013, "Nokia");
        CellPhone cellPhone4 = new CellPhone(10003, 28.99, 2016, "Blackberry");
        CellPhone cellPhone5 = new CellPhone(10004, 34.99, 2010, "HTC");
        CellPhone cellPhone6 = new CellPhone(10005, 100.99, 2015, "Samsung");
        myCellList1.addToStart(cellPhone1);
        myCellList1.addToStart(cellPhone2);
        myCellList1.addToStart(cellPhone3);
        myCellList1.addToStart(cellPhone4);
        myCellList1.addToStart(cellPhone5);
        myCellList1.showContents();
        myCellList1.replaceAtIndex(cellPhone6, 0);
        myCellList1.deleteFromIndex(2);
        myCellList1.showContents();
        System.out.println(myCellList1.size());
        CellList myCellList2 = myCellList1.clone();
        myCellList2.showContents();
    }

}