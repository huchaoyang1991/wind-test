package com.sun.utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by huchaoyang on 2017/7/15.
 */
public class ExcelData implements Iterator<Object[]> {
	private static Logger logger=Logger.getLogger(ExcelData.class);//声明log4j日志
	private Workbook book;
	private Sheet sheet;
	private int rowNum;//行数
	private int columnNum;//列数
	private int curRowNum;//当前行数
	private String[] columName;//列名
	public ExcelData(Object object){
		try {
			//获取数据驱动所在路径
			String fileName=object.getClass().getSimpleName();
			String filePath=new File("").getCanonicalPath()+"\\src\\main\\resources\\dataDriver\\"+fileName+".xls";
			//获取对应路径下的xls文件
			this.book=Workbook.getWorkbook(new File(filePath));
			//获取第一个sheet表信息
			this.sheet=book.getSheet(0);
			//获取行数
			this.rowNum=sheet.getRows();
			//获取列数
			this.columnNum =sheet.getColumns();
			//获取第一行信息
			Cell[] cells=sheet.getRow(0);
			//为列名数组分配内存空间
			this.columName=new String[columnNum];
			for (int i = 0; i < columnNum; i++) {
				this.columName[i]=cells[i].getContents();
			}
			this.curRowNum++;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean hasNext() {
		if(this.curRowNum==0||this.curRowNum>= this.rowNum) {
			//如果迭代结束，记得释放资源
			try {
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		else
			return true;
	}

	@Override
	public Object[] next() {
		Cell[] cells=sheet.getRow(curRowNum);
		Map<String,String> map=new TreeMap<String,String>();
		for (int i = 0; i <this.columnNum; i++) {
			map.put(this.columName[i],cells[i].getContents());
		}
		this.curRowNum++;
		Object[] obj=new Object[1];
		obj[0]=map;
		return obj;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove unsupported");
	}

}
