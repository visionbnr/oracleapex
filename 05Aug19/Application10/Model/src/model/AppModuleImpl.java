package model;

import model.common.AppModule;

import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Aug 01 21:05:33 IST 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends ApplicationModuleImpl implements AppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
    }

    public void employessList() {
        //Get Master ViewObject
        ViewObject deptVo = this.getDepartmentVO1();
        //Create iterator to iterate over master viewObject
        RowSetIterator rsi = deptVo.createRowSetIterator(null);

        while (rsi.hasNext()) {
            //Get Master ViewObject Row
            Row departmentsRow = rsi.next();
            ///System.out.println("Department Name :" + departmentsRow.getAttribute("DepartmentName"));
            //Get Corresponding child viewobject accessor
            RowSet rs = (RowSet) departmentsRow.getAttribute("EmployeesVO");
            //Iterate over child viewObject rows for corresponding master record
            while (rs.hasNext()) {
                Row r = rs.next();
                //if (r.getAttribute("SelectCheck2") != null && r.getAttribute("SelectCheck2").equals(true)) {
                if ( departmentsRow.getAttribute("DepartmentName")!= null && departmentsRow.getAttribute("DepartmentName").equals("IT")) {
                System.out.println(" Employee : " + r.getAttribute("FirstName") + " " + r.getAttribute("LastName")+ " " + r.getAttribute("SelectCheck")
                                   +" "+r.getAttribute("SelectCheck1")+" "+r.getAttribute("SelectCheck2"));
                }
            }
        }
        //Close Master viewObject iterator
        rsi.closeRowSetIterator();
    }
    
    public void employessList2() {
        //Get Master ViewObject
        ViewObject deptVo = this.getDepartmentVO1();
        //Create iterator to iterate over master viewObject
        RowSetIterator rsi = deptVo.createRowSetIterator(null);

        while (rsi.hasNext()) {
            //Get Master ViewObject Row
            Row departmentsRow = rsi.next();
            System.out.println("Department Name :" + departmentsRow.getAttribute("DepartmentName"));
            //Get Corresponding child viewobject accessor
            RowSet rs = (RowSet) departmentsRow.getAttribute("EmployeesVO");
            //Iterate over child viewObject rows for corresponding master record
            while (rs.hasNext()) {
                Row r = rs.next();
                if (r.getAttribute("SelectCheck2") != null && r.getAttribute("SelectCheck2").equals(true)) {
                System.out.println(" Employee : " + r.getAttribute("FirstName") + " " + r.getAttribute("LastName"));
                }
            }
        }
        //Close Master viewObject iterator
        rsi.closeRowSetIterator();
    }

    public void employessList1() {
        ViewObject view_object1 = getDepartmentVO1();
        RowSetIterator iter1 = view_object1.createRowSetIterator(null);
        while (iter1.hasNext()) {
            ViewObject view_object2 = getEmployeesVO1();
            RowSetIterator rsi = view_object2.createRowSetIterator(null);
            while (rsi.hasNext()) {
                //rsi Master ViewObject Row
                Row departmentsRow = rsi.next();
                System.out.println("Department Name :" + departmentsRow.getAttribute("DepartmentName"));
                //Get Corresponding child viewobject accessor
                RowSet rs = (RowSet) departmentsRow.getAttribute("EmployeesVO");

                Row r2 = rsi.next();
                if (r2.getAttribute("SelectCheck2") != null && r2.getAttribute("SelectCheck2").equals(true)) {
                    System.out.println("FirstName=" + r2.getAttribute("FirstName"));
                }
            }
        }
    }

    /**
     * Container's getter for DepartmentVO1.
     * @return DepartmentVO1
     */
    public DepartmentVOImpl getDepartmentVO1() {
        return (DepartmentVOImpl) findViewObject("DepartmentVO1");
    }

    /**
     * Container's getter for EmployeesVO1.
     * @return EmployeesVO1
     */
    public ViewObjectImpl getEmployeesVO1() {
        return (ViewObjectImpl) findViewObject("EmployeesVO1");
    }

    /**
     * Container's getter for DeptEmpVL1.
     * @return DeptEmpVL1
     */
    public ViewLinkImpl getDeptEmpVL1() {
        return (ViewLinkImpl) findViewLink("DeptEmpVL1");
    }
}

