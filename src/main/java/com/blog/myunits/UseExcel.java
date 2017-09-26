package com.blog.myunits;

import com.blog.entity.ClassMastesUser;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 使用jxl操作Excel
 *
 * @Author Liu-shuwei
 * @Date 17.6.25
 */
public class UseExcel {
    /**************************************应用功能**********************************************************/
    //将classMastesUser的数据导出到excel表格
    public   void eportClassMastesMessage(String pathFileName,List<ClassMastesUser> clist) throws IOException,WriteException {

        //1.新建文件，设置目录
        File xlsFile = new File(pathFileName);


        //2.创建工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);

        //3.创建工作表
        WritableSheet sheet = workbook.createSheet("sheet1", 0);

        //4.起始行
        String [] rowName = {"用户id","姓名","手机","目前居住城市","详细地址(单位或者家庭)","邮编","提交时间"};
        for(int i = 0; i < 7; i++){
            Label lb = new Label(i,0,rowName[i]);
            sheet.addCell(lb);  // 向工作表中添加数据
        }

        //5.起始列
        int row = 1; //从第二行开始
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

        for(ClassMastesUser c:clist){
            Label id = new Label(0,row,String.valueOf(c.getId()));
            Label name = new Label(1,row,c.getName());
            Label phone = new Label(2,row,c.getPhone());
            Label city = new Label(3,row,c.getCity());
            Label area = new Label(4,row,c.getArea());
            Label postCode = new Label(5,row,c.getPostCode());
            Label publictime = new Label(6,row,sdf.format(c.getPublictime()));

            sheet.addCell(id);  // 向工作表中添加数据
            sheet.addCell(name);
            sheet.addCell(phone);
            sheet.addCell(city);
            sheet.addCell(area);
            sheet.addCell(postCode);
            sheet.addCell(publictime);

            row++;

        }

        //4.写入数据
        workbook.write();

        //5.关闭流
        workbook.close();
    }

    /**************************************用于测试**********************************************************/
    //方法1-2：创建Excel文件，写入数据
    public   void createExcel() throws IOException,WriteException {
        //1.新建文件，设置目录
        File xlsFile = new File("C:\\Users\\Liu-shuwei\\Desktop\\用户表.xls");

        //2.创建工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);

        //3.创建工作表
        WritableSheet sheet = workbook.createSheet("sheet1", 0);
        for (int row = 0; row < 10; row++){
            for (int col = 0; col < 10; col++) {

                //第col列【从0开始】，第row行【从0开始】，数据
                Label lb = new Label(col,row,"数据【"+col+"列"+row+"行】");
                sheet.addCell(lb);  // 向工作表中添加数据
            }
        }

        //4.写入数据
        workbook.write();

        //5.关闭流
        workbook.close();
    }

    //方法1-2：获取Excel表的所有数据
    public  HashMap[] getExcelData(String excelFilePath) throws IOException,BiffException{	//返回数组[HashMap<“rows”，ArrayList>]

        File xlsFile = new File(excelFilePath);												//1.定位文件
        Workbook workbook = Workbook.getWorkbook(xlsFile); 		    //2.获得工作薄对象
        Sheet [] sheets = workbook.getSheets();										    //3.获得所有工作表

        HashMap [] sheets_map=new HashMap[sheets.length];																	//<表号，所有表,>


        //4.遍历工作表
        if(sheets  != null){
            //A层-工作表
            for(int s = 0; s < sheets.length; s++){

                //B层-所有行
                HashMap<Integer,ArrayList<String>> rows_map =  new HashMap<Integer,ArrayList<String>>();                       //<行号，行的所有列>
                for(int row =0 ;row<sheets[s].getRows();row++){
                    Cell[] cells =sheets[s].getRow(row);										//获取整行数据,保存进数组,Sheet.getColumn()是获取整列

                    //C层-所有列
                    ArrayList<String> cols_list = new ArrayList<String>();                                                                  //有序集合，储存所有列的信息
                    for(int col = 0;col < sheets[s].getColumns();col++){  //C层-所有列
                        cols_list.add(sheets[s].getCell(col,row).getContents());
//						System.out.printf("%10s",sheets[s].getCell(col,row).getContents());
                    }

                    rows_map.put(row, cols_list);
                }

                sheets_map[s]=rows_map;
            }
        }



        workbook.close();
        return sheets_map;

    }

    //方法1-3：读取UseExcel表格,返回拥有的工作表名
    public ArrayList<String> getExcelSheetsName(String filePath) throws IOException, BiffException {
        //1.创建ArrayList对象用于储存表名
        ArrayList<String> alist= new ArrayList<String>();


        //2.定位Excel,获得工作薄对象
        File xlsFile = new File(filePath);
        Workbook workbook = Workbook.getWorkbook(xlsFile);

        //3.获取所有工作表名
        for(Sheet sheet:workbook.getSheets()){
            alist.add(sheet.getName());
        }

        return alist;
    }
}
