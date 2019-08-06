package view;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;

import oracle.binding.BindingContainer;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.client.Configuration;

import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import java.util.Map;

import javax.faces.context.FacesContext;

import model.DepartmentVORowImpl;

import oracle.adf.model.AttributeBinding;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.component.UIXSwitcher;


public class MasterChild {

    private RichInputText jobInputBind;
    private RichTable deptTable;
    private RichTable deptTableBinding;
    private RichTable empTableBinding;
    private UIXSwitcher homeSelUnSel;
    private String homeDynaFacet;
    private boolean homeSelectCheckBox;
    private boolean homeUrlCheckboxED;
    private boolean urLSelectCheckBox;
    private RichSelectBooleanCheckbox chk2Bind;
    private RichSelectBooleanCheckbox cb1db;

    public MasterChild() {
    }

    public String LoadTables() {
        // Add event code here...
        return null;
    }

    public void childCheckBox(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        // #{bindings.EmployeesVO1.collectionModel.makeCurrent}
    }


    public void setJobInputBind(RichInputText jobInputBind) {
        this.jobInputBind = jobInputBind;
    }

    public RichInputText getJobInputBind() {
        return jobInputBind;
    }

    public void submitButtonClick(ActionEvent actionEvent) {
        String str = null;
        if (getJobInputBind().getValue() != null)
            str = getJobInputBind().getValue().toString();
        System.out.println("Str=" + str);
        //homeDynaFacet="CheckHUnSel";
        if (str != null && str.equals("HomeSelect")) {
            //homeDynaFacet="CheckHSel";
            homeSelectCheckBox = true;
            homeUrlCheckboxED = true;
            urLSelectCheckBox = true;
        } else {
            // homeDynaFacet="CheckHUnSel";
            homeSelectCheckBox = false;
            homeUrlCheckboxED = false;
            urLSelectCheckBox = false;
        }
        BindingContext context = BindingContext.getCurrent();
        //Call Iterator binding - EmployeeEOVO1Iterator
        DCBindingContainer dcBindCont = (DCBindingContainer) context.getCurrentBindingsEntry();
        DCIteratorBinding dc_iter = dcBindCont.findIteratorBinding("DepartmentVO1Iterator");
        //Get the currentRow
        Row currRow = dc_iter.getCurrentRow();
        ViewObject view_object = dc_iter.getViewObject();

        view_object.executeQuery();
        //view_object.executeEmptyRowSet();

        ////dc_iter.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(deptTableBinding);
        // AdfFacesContext.getCurrentInstance().addPartialTarget(getEmpTableBinding());
        //Get the Appilication Module
        ////////ApplicationModule appModule = view_object.getApplicationModule();
        //Call Iterator
        /*
          RowSetIterator iter =  view_object.createRowSetIterator(null);
          while (iter.hasNext()){
              Row r = iter.next();
              r.getAttribute("FirstName");
          }
        */
    }

    public void setDeptTable(RichTable deptTable) {
        this.deptTable = deptTable;
    }

    public RichTable getDeptTable() {
        return deptTable;
    }

    public void setDeptTableBinding(RichTable deptTableBinding) {
        this.deptTableBinding = deptTableBinding;
    }

    public RichTable getDeptTableBinding() {
        return deptTableBinding;
    }

    public void setEmpTableBinding(RichTable empTableBinding) {
        this.empTableBinding = empTableBinding;
    }

    public RichTable getEmpTableBinding() {
        return empTableBinding;
    }

    public void setHomeSelUnSel(UIXSwitcher homeSelUnSel) {
        this.homeSelUnSel = homeSelUnSel;
    }

    public UIXSwitcher getHomeSelUnSel() {
        return homeSelUnSel;
    }

    public void setHomeDynaFacet(String homeDynaFacet) {
        this.homeDynaFacet = homeDynaFacet;
    }

    public String getHomeDynaFacet() {
        return homeDynaFacet;
    }

    public void setHomeSelectCheckBox(boolean homeSelectCheckBox) {
        this.homeSelectCheckBox = homeSelectCheckBox;
    }

    public boolean getHomeSelectCheckBox() {
        return homeSelectCheckBox;
    }

    public void setHomeUrlCheckboxED(boolean homeUrlCheckboxED) {
        this.homeUrlCheckboxED = homeUrlCheckboxED;
    }

    public boolean getHomeUrlCheckboxED() {
        return homeUrlCheckboxED;
    }

    public void setUrLSelectCheckBox(boolean urLSelectCheckBox) {
        this.urLSelectCheckBox = urLSelectCheckBox;
    }

    public boolean getUrLSelectCheckBox() {
        return urLSelectCheckBox;
    }

    public void childCheckboxVCE(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
    }

    public void childCheckboxVCE1(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        BindingContext context = BindingContext.getCurrent();
        //Call Iterator binding - EmployeeEOVO1Iterator
        DCBindingContainer dcBindCont = (DCBindingContainer) context.getCurrentBindingsEntry();
        DCIteratorBinding dc_iter = dcBindCont.findIteratorBinding("EmployeesVO1Iterator");

        // DCBindingContainer dcb = (DCBindingContainer)getBindings();
        //DCIteratorBinding dcItr = dcb .findIteratorBinding("EmployeesVO1Iterator");
        RowSetIterator rsIter = dc_iter.getRowSetIterator();
        Row rowObj = rsIter.getCurrentRow();
        if (rowObj.getAttribute("SelectCheck1").equals(true))
            rowObj.setAttribute("SelectCheck1", true);
        else
            rowObj.setAttribute("SelectCheck1", false);

    }

    public String b2_action12345() {
        System.out.println("***** b2_action *****");
        BindingContext context = BindingContext.getCurrent();
        //Call Iterator binding - EmployeeEOVO1Iterator
        DCBindingContainer dcBindCont = (DCBindingContainer) context.getCurrentBindingsEntry();
        DCIteratorBinding dc_iter = dcBindCont.findIteratorBinding("EmployeesVO1Iterator");
        //Get the currentRow
        Row currRow = dc_iter.getCurrentRow();
        ViewObject view_object = dc_iter.getViewObject();
        RowSetIterator iter = view_object.createRowSetIterator(null);
        while (iter.hasNext()) {
            Row r = iter.next();
            if (r.getAttribute("SelectCheck2") != null && r.getAttribute("SelectCheck2").equals(true)) {
                System.out.println("FirstName=" + r.getAttribute("FirstName"));
            }
        }
        return null;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String b3_action() {
        OperationBinding ob = getBindings().getOperationBinding("employessList");
        //Passing parameter to method -Get parameter map and use paramater name as key
        //ob.getParamsMap().put("deptId", 9999);
        //Execute this method
        ob.execute();
        return null;
    }

    public String b2_action() {
        System.out.println("***** b2_action *****");
        BindingContext context = BindingContext.getCurrent();

        DCBindingContainer dcBindCont = (DCBindingContainer) context.getCurrentBindingsEntry();
        DCIteratorBinding dc_iter = dcBindCont.findIteratorBinding("DepartmentVO1Iterator");
        //Get the currentRow
        Row currRow = dc_iter.getCurrentRow();
        ViewObject deptVo = dc_iter.getViewObject();
        //Get Master ViewObject
        ////////ViewObject deptVo = this.getDepartmentVO1();
        //Create iterator to iterate over master viewObject
        RowSetIterator rsi = deptVo.createRowSetIterator(null);
        while (rsi.hasNext()) {
            //Get Master ViewObject Row
            Row departmentsRow = rsi.next();
            //Call Iterator binding - EmployeeEOVO1Iterator
            DCBindingContainer dcBindCont1 = (DCBindingContainer) context.getCurrentBindingsEntry();
            DCIteratorBinding dc_iter1 = dcBindCont1.findIteratorBinding("EmployeesVO1Iterator");
            //Get the currentRow
            //Row currRow=dc_iter1.getCurrentRow();
            ViewObject view_object1 = dc_iter1.getViewObject();
            RowSetIterator iter1 = view_object1.createRowSetIterator(null);
            while (iter1.hasNext()) {
                Row r = iter1.next();
                if (r.getAttribute("SelectCheck2") != null && r.getAttribute("SelectCheck2").equals(true)) {
                    System.out.println("FirstName=" + r.getAttribute("FirstName"));
                }
            }
        }
        return null;
    }

    public void employessList() {
        System.out.println("*** employessList ****");
        BindingContext context = BindingContext.getCurrent();
        //Call Iterator binding - EmployeeEOVO1Iterator
        DCBindingContainer dcBindCont = (DCBindingContainer) context.getCurrentBindingsEntry();
        DCIteratorBinding dc_iter = dcBindCont.findIteratorBinding("DepartmentVO1Iterator");
        //Get the currentRow
        Row currRow = dc_iter.getCurrentRow();
        ViewObject deptVo = dc_iter.getViewObject();
        //Get Master ViewObject
        ////////ViewObject deptVo = this.getDepartmentVO1();
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
                if (departmentsRow.getAttribute("DepartmentName") != null &&
                    departmentsRow.getAttribute("DepartmentName").equals("IT")) {
                    
                   // AttributeBinding attr = (AttributeBinding)getBindings().getControlBinding("SelectCheck");
                     //System.out.println("attv value="+attr.getInputValue()); 
                    System.out.println(" Employee : " + r.getAttribute("FirstName") + " " + r.getAttribute("LastName") +
                                       " " + r.getAttribute("SelectCheck")+
                                       " " + r.getAttribute("Empchkbox") +
                                       " " + r.getAttribute("Emptextbox"));
                    //System.out.println(" Employee : " + r.getAttribute("FirstName") + " " + r.getAttribute("LastName") +
                      //                 " " + r.getAttribute("SelectCheck") + " " + r.getAttribute("SelectCheck1") +
                        //               " " + r.getAttribute("SelectCheck2") + " " + r.getAttribute("Empchkbox") +
                          //             r.getAttribute("Emptextbox"));
                }
            }
        }
        //Close Master viewObject iterator
        rsi.closeRowSetIterator();
    }

    public void sampleMethod() {
        BindingContext context = BindingContext.getCurrent();
        //Call Iterator binding - EmployeeEOVO1Iterator
        DCBindingContainer dcBindCont = (DCBindingContainer) context.getCurrentBindingsEntry();
        DCIteratorBinding dc_iter = dcBindCont.findIteratorBinding("DepartmentVO1Iterator");
        //Get the currentRow
        Row currRow = dc_iter.getCurrentRow();
        ViewObject deptVO = dc_iter.getViewObject();

        //getting reference to deptVO
        //////////ViewObjectImpl deptVO = this.getDeptVO();
        //setting range size to -1 to get all dept rows
        deptVO.setRangeSize(-1);
        //getting all dept rows
        Row[] deptRows = deptVO.getAllRowsInRange();
        //iterating through all dept rows
        for (int i = 0; i < deptRows.length; i++) {
            //getting reference to each dept row. Note that we're type casting the VO reference type to DeptVORowImpl.
            DepartmentVORowImpl deptRow = (DepartmentVORowImpl) deptRows[i];
            //printing dept name
            System.out.println("Employees in dept: " + deptRow.getAttribute("DepartmentName"));
            //For each dept row, getting reference to empVO which contains all employees corresponding to current dept
           // RowIterator empRows = deptRow.getEmployeesVO();
           RowIterator empRows = deptRow.getEmployeesVO();
             
            //iterating each emp row
            while (empRows.hasNext()) {
                Row r = empRows.next();
                //printing emp name from each row
                //System.out.println(empRow.getAttribute("Ename"));
                System.out.println(" Employee : " + r.getAttribute("FirstName") + " " + r.getAttribute("LastName") +
                                   " " + r.getAttribute("SelectCheck") + " " + r.getAttribute("SelectCheck1") + " " +
                                   r.getAttribute("SelectCheck2") + " " + r.getAttribute("Empchkbox") +
                                   r.getAttribute("Emptextbox"));
            }
        }
    }

    public String b4_action() {
        AttributeBinding attr = (AttributeBinding)getBindings().getControlBinding("SelectCheck");
         System.out.println("attv value="+attr.getInputValue()); 
        employessList();
        //sampleMethod();
        return null;
    }

    public void Chk1VCE(ValueChangeEvent valueChangeEvent) {
       /*
        DCBindingContainer dcb = (DCBindingContainer) getBindings();
        DCIteratorBinding dcItr = dcb.findIteratorBinding("EmployeesVO1Iterator");
        RowSetIterator rsIter = dcItr.getRowSetIterator();
        Row rowObj = rsIter.getCurrentRow();
        if (rowObj != null && rowObj.getAttribute("SelectCheck1") != null &&
            rowObj.getAttribute("SelectCheck1").equals(true)) {
            System.out.println("SelectCheck1=" + rowObj.getAttribute("SelectCheck1"));
            rowObj.setAttribute("SelectCheck2", true);
            rowObj.setAttribute("Empchkbox", true);
        } else
        {
            rowObj.setAttribute("SelectCheck2", false);
            rowObj.setAttribute("Empchkbox", false);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(chk2Bind);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cb1db);
*/
    }

    public void setChk2Bind(RichSelectBooleanCheckbox chk2Bind) {
        this.chk2Bind = chk2Bind;
    }

    public RichSelectBooleanCheckbox getChk2Bind() {
        return chk2Bind;
    }

    public void setCb1db(RichSelectBooleanCheckbox cb1db) {
        this.cb1db = cb1db;
    }

    public RichSelectBooleanCheckbox getCb1db() {
        return cb1db;
    }
}
