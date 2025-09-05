/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package com.idlogix.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for SAP_Invoiceline
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="SAP_Invoiceline")
public class X_SAP_Invoiceline extends PO implements I_SAP_Invoiceline, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250829L;

    /** Standard Constructor */
    public X_SAP_Invoiceline (Properties ctx, int SAP_Invoiceline_ID, String trxName)
    {
      super (ctx, SAP_Invoiceline_ID, trxName);
      /** if (SAP_Invoiceline_ID == 0)
        {
			setSAP_Invoiceline_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_SAP_Invoiceline (Properties ctx, int SAP_Invoiceline_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, SAP_Invoiceline_ID, trxName, virtualColumns);
      /** if (SAP_Invoiceline_ID == 0)
        {
			setSAP_Invoiceline_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_SAP_Invoiceline (Properties ctx, String SAP_Invoiceline_UU, String trxName)
    {
      super (ctx, SAP_Invoiceline_UU, trxName);
      /** if (SAP_Invoiceline_UU == null)
        {
			setSAP_Invoiceline_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_SAP_Invoiceline (Properties ctx, String SAP_Invoiceline_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, SAP_Invoiceline_UU, trxName, virtualColumns);
      /** if (SAP_Invoiceline_UU == null)
        {
			setSAP_Invoiceline_ID (0);
        } */
    }

    /** Load Constructor */
    public X_SAP_Invoiceline (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_SAP_Invoiceline[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Discount %.
		@param Discount Discount in percent
	*/
	public void setDiscount (BigDecimal Discount)
	{
		set_ValueNoCheck (COLUMNNAME_Discount, Discount);
	}

	/** Get Discount %.
		@return Discount in percent
	  */
	public BigDecimal getDiscount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Discount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Rate.
		@param Rate Rate or Tax or Exchange
	*/
	public void setRate (String Rate)
	{
		set_Value (COLUMNNAME_Rate, Rate);
	}

	/** Get Rate.
		@return Rate or Tax or Exchange
	  */
	public String getRate()
	{
		return (String)get_Value(COLUMNNAME_Rate);
	}

	public I_SAP_Invoice getSAP_Invoice() throws RuntimeException
	{
		return (I_SAP_Invoice)MTable.get(getCtx(), I_SAP_Invoice.Table_ID)
			.getPO(getSAP_Invoice_ID(), get_TrxName());
	}

	/** Set SAP_Invoice_ID.
		@param SAP_Invoice_ID SAP_Invoice_ID
	*/
	public void setSAP_Invoice_ID (int SAP_Invoice_ID)
	{
		if (SAP_Invoice_ID < 1)
			set_ValueNoCheck (COLUMNNAME_SAP_Invoice_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_SAP_Invoice_ID, Integer.valueOf(SAP_Invoice_ID));
	}

	/** Get SAP_Invoice_ID.
		@return SAP_Invoice_ID	  */
	public int getSAP_Invoice_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SAP_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set SAP_Invoiceline.
		@param SAP_Invoiceline_ID SAP_Invoiceline
	*/
	public void setSAP_Invoiceline_ID (int SAP_Invoiceline_ID)
	{
		if (SAP_Invoiceline_ID < 1)
			set_ValueNoCheck (COLUMNNAME_SAP_Invoiceline_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_SAP_Invoiceline_ID, Integer.valueOf(SAP_Invoiceline_ID));
	}

	/** Get SAP_Invoiceline.
		@return SAP_Invoiceline	  */
	public int getSAP_Invoiceline_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SAP_Invoiceline_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set extra_tax.
		@param extra_tax extra_tax
	*/
	public void setextra_tax (BigDecimal extra_tax)
	{
		set_Value (COLUMNNAME_extra_tax, extra_tax);
	}

	/** Get extra_tax.
		@return extra_tax	  */
	public BigDecimal getextra_tax()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_extra_tax);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set fed_payable.
		@param fed_payable fed_payable
	*/
	public void setfed_payable (BigDecimal fed_payable)
	{
		set_Value (COLUMNNAME_fed_payable, fed_payable);
	}

	/** Get fed_payable.
		@return fed_payable	  */
	public BigDecimal getfed_payable()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_fed_payable);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set fixed_notified_value_or_retail_price.
		@param fixed_notified_value_or_retail_price fixed_notified_value_or_retail_price
	*/
	public void setfixed_notified_value_or_retail_price (BigDecimal fixed_notified_value_or_retail_price)
	{
		set_Value (COLUMNNAME_fixed_notified_value_or_retail_price, fixed_notified_value_or_retail_price);
	}

	/** Get fixed_notified_value_or_retail_price.
		@return fixed_notified_value_or_retail_price	  */
	public BigDecimal getfixed_notified_value_or_retail_price()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_fixed_notified_value_or_retail_price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set further_tax.
		@param further_tax further_tax
	*/
	public void setfurther_tax (BigDecimal further_tax)
	{
		set_Value (COLUMNNAME_further_tax, further_tax);
	}

	/** Get further_tax.
		@return further_tax	  */
	public BigDecimal getfurther_tax()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_further_tax);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set hs_code.
		@param hs_code hs_code
	*/
	public void seths_code (String hs_code)
	{
		set_Value (COLUMNNAME_hs_code, hs_code);
	}

	/** Get hs_code.
		@return hs_code	  */
	public String geths_code()
	{
		return (String)get_Value(COLUMNNAME_hs_code);
	}

	/** Set product_description.
		@param product_description product_description
	*/
	public void setproduct_description (String product_description)
	{
		set_Value (COLUMNNAME_product_description, product_description);
	}

	/** Get product_description.
		@return product_description	  */
	public String getproduct_description()
	{
		return (String)get_Value(COLUMNNAME_product_description);
	}

	/** Set quantity.
		@param quantity quantity
	*/
	public void setquantity (BigDecimal quantity)
	{
		set_Value (COLUMNNAME_quantity, quantity);
	}

	/** Get quantity.
		@return quantity	  */
	public BigDecimal getquantity()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_quantity);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set sale_type.
		@param sale_type sale_type
	*/
	public void setsale_type (String sale_type)
	{
		set_Value (COLUMNNAME_sale_type, sale_type);
	}

	/** Get sale_type.
		@return sale_type	  */
	public String getsale_type()
	{
		return (String)get_Value(COLUMNNAME_sale_type);
	}

	/** Set sales_tax_applicable.
		@param sales_tax_applicable sales_tax_applicable
	*/
	public void setsales_tax_applicable (BigDecimal sales_tax_applicable)
	{
		set_Value (COLUMNNAME_sales_tax_applicable, sales_tax_applicable);
	}

	/** Get sales_tax_applicable.
		@return sales_tax_applicable	  */
	public BigDecimal getsales_tax_applicable()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_sales_tax_applicable);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set sales_tax_withheld_at_source.
		@param sales_tax_withheld_at_source sales_tax_withheld_at_source
	*/
	public void setsales_tax_withheld_at_source (BigDecimal sales_tax_withheld_at_source)
	{
		set_Value (COLUMNNAME_sales_tax_withheld_at_source, sales_tax_withheld_at_source);
	}

	/** Get sales_tax_withheld_at_source.
		@return sales_tax_withheld_at_source	  */
	public BigDecimal getsales_tax_withheld_at_source()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_sales_tax_withheld_at_source);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set sro_item_serial_no.
		@param sro_item_serial_no sro_item_serial_no
	*/
	public void setsro_item_serial_no (String sro_item_serial_no)
	{
		set_Value (COLUMNNAME_sro_item_serial_no, sro_item_serial_no);
	}

	/** Get sro_item_serial_no.
		@return sro_item_serial_no	  */
	public String getsro_item_serial_no()
	{
		return (String)get_Value(COLUMNNAME_sro_item_serial_no);
	}

	/** Set sro_schedule_no.
		@param sro_schedule_no sro_schedule_no
	*/
	public void setsro_schedule_no (String sro_schedule_no)
	{
		set_Value (COLUMNNAME_sro_schedule_no, sro_schedule_no);
	}

	/** Get sro_schedule_no.
		@return sro_schedule_no	  */
	public String getsro_schedule_no()
	{
		return (String)get_Value(COLUMNNAME_sro_schedule_no);
	}

	/** Set supply_destination.
		@param supply_destination supply_destination
	*/
	public void setsupply_destination (String supply_destination)
	{
		set_Value (COLUMNNAME_supply_destination, supply_destination);
	}

	/** Get supply_destination.
		@return supply_destination	  */
	public String getsupply_destination()
	{
		return (String)get_Value(COLUMNNAME_supply_destination);
	}

	/** Set total_values.
		@param total_values total_values
	*/
	public void settotal_values (BigDecimal total_values)
	{
		set_Value (COLUMNNAME_total_values, total_values);
	}

	/** Get total_values.
		@return total_values	  */
	public BigDecimal gettotal_values()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_total_values);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** 1000 kWh = 1000 kWh */
	public static final String UOM_1000KWh = "1000 kWh";
	/** 40KG = 40KG */
	public static final String UOM_40KG = "40KG";
	/** Bag = Bag */
	public static final String UOM_Bag = "Bag";
	/** Barrels = Barrels */
	public static final String UOM_Barrels = "Barrels";
	/** Bill of lading = Bill of lading */
	public static final String UOM_BillOfLading = "Bill of lading";
	/** Carat = Carat */
	public static final String UOM_Carat = "Carat";
	/** Cubic Metre = Cubic Metre */
	public static final String UOM_CubicMetre = "Cubic Metre";
	/** Dozen = Dozen */
	public static final String UOM_Dozen = "Dozen";
	/** Foot = Foot */
	public static final String UOM_Foot = "Foot";
	/** Gallon = Gallon */
	public static final String UOM_Gallon = "Gallon";
	/** Gram = Gram */
	public static final String UOM_Gram = "Gram";
	/** KG = KG */
	public static final String UOM_KG = "KG";
	/** KWH = KWH */
	public static final String UOM_KWH = "KWH";
	/** Kilogram = Kilogram */
	public static final String UOM_Kilogram = "Kilogram";
	/** Liter = Liter */
	public static final String UOM_Liter = "Liter";
	/** MMBTU = MMBTU */
	public static final String UOM_MMBTU = "MMBTU";
	/** MT = MT */
	public static final String UOM_MT = "MT";
	/** Mega Watt = Mega Watt */
	public static final String UOM_MegaWatt = "Mega Watt";
	/** Meter = Meter */
	public static final String UOM_Meter = "Meter";
	/** NO = NO */
	public static final String UOM_NO = "NO";
	/** Numbers, pieces, units = Numbers, pieces, units */
	public static final String UOM_NumbersPiecesUnits = "Numbers, pieces, units";
	/** Others = Others */
	public static final String UOM_Others = "Others";
	/** Packs = Packs */
	public static final String UOM_Packs = "Packs";
	/** Pair = Pair */
	public static final String UOM_Pair = "Pair";
	/** Pcs = Pcs */
	public static final String UOM_Pcs = "Pcs";
	/** Pound = Pound */
	public static final String UOM_Pound = "Pound";
	/** SET = SET */
	public static final String UOM_SET = "SET";
	/** SqY = SqY */
	public static final String UOM_SqY = "SqY";
	/** Square Foot = Square Foot */
	public static final String UOM_SquareFoot = "Square Foot";
	/** Square Metre = Square Metre */
	public static final String UOM_SquareMetre = "Square Metre";
	/** Thousand Unit = Thousand Unit */
	public static final String UOM_ThousandUnit = "Thousand Unit";
	/** Timber Logs = Timber Logs */
	public static final String UOM_TimberLogs = "Timber Logs";
	/** Set uom.
		@param uom uom
	*/
	public void setuom (String uom)
	{

		set_Value (COLUMNNAME_uom, uom);
	}

	/** Get uom.
		@return uom	  */
	public String getuom()
	{
		return (String)get_Value(COLUMNNAME_uom);
	}

	/** Set value_sales_excluding_st.
		@param value_sales_excluding_st value_sales_excluding_st
	*/
	public void setvalue_sales_excluding_st (BigDecimal value_sales_excluding_st)
	{
		set_Value (COLUMNNAME_value_sales_excluding_st, value_sales_excluding_st);
	}

	/** Get value_sales_excluding_st.
		@return value_sales_excluding_st	  */
	public BigDecimal getvalue_sales_excluding_st()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_value_sales_excluding_st);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}