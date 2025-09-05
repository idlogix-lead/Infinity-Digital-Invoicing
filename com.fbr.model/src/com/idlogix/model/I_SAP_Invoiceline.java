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
package com.idlogix.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for SAP_Invoiceline
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_SAP_Invoiceline 
{

    /** TableName=SAP_Invoiceline */
    public static final String Table_Name = "SAP_Invoiceline";

    /** AD_Table_ID=1000003 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Discount */
    public static final String COLUMNNAME_Discount = "Discount";

	/** Set Discount %.
	  * Discount in percent
	  */
	public void setDiscount (BigDecimal Discount);

	/** Get Discount %.
	  * Discount in percent
	  */
	public BigDecimal getDiscount();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Rate */
    public static final String COLUMNNAME_Rate = "Rate";

	/** Set Rate.
	  * Rate or Tax or Exchange
	  */
	public void setRate (String Rate);

	/** Get Rate.
	  * Rate or Tax or Exchange
	  */
	public String getRate();

    /** Column name SAP_Invoice_ID */
    public static final String COLUMNNAME_SAP_Invoice_ID = "SAP_Invoice_ID";

	/** Set SAP_Invoice_ID	  */
	public void setSAP_Invoice_ID (int SAP_Invoice_ID);

	/** Get SAP_Invoice_ID	  */
	public int getSAP_Invoice_ID();

	public I_SAP_Invoice getSAP_Invoice() throws RuntimeException;

    /** Column name SAP_Invoiceline_ID */
    public static final String COLUMNNAME_SAP_Invoiceline_ID = "SAP_Invoiceline_ID";

	/** Set SAP_Invoiceline	  */
	public void setSAP_Invoiceline_ID (int SAP_Invoiceline_ID);

	/** Get SAP_Invoiceline	  */
	public int getSAP_Invoiceline_ID();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name extra_tax */
    public static final String COLUMNNAME_extra_tax = "extra_tax";

	/** Set extra_tax	  */
	public void setextra_tax (BigDecimal extra_tax);

	/** Get extra_tax	  */
	public BigDecimal getextra_tax();

    /** Column name fed_payable */
    public static final String COLUMNNAME_fed_payable = "fed_payable";

	/** Set fed_payable	  */
	public void setfed_payable (BigDecimal fed_payable);

	/** Get fed_payable	  */
	public BigDecimal getfed_payable();

    /** Column name fixed_notified_value_or_retail_price */
    public static final String COLUMNNAME_fixed_notified_value_or_retail_price = "fixed_notified_value_or_retail_price";

	/** Set fixed_notified_value_or_retail_price	  */
	public void setfixed_notified_value_or_retail_price (BigDecimal fixed_notified_value_or_retail_price);

	/** Get fixed_notified_value_or_retail_price	  */
	public BigDecimal getfixed_notified_value_or_retail_price();

    /** Column name further_tax */
    public static final String COLUMNNAME_further_tax = "further_tax";

	/** Set further_tax	  */
	public void setfurther_tax (BigDecimal further_tax);

	/** Get further_tax	  */
	public BigDecimal getfurther_tax();

    /** Column name hs_code */
    public static final String COLUMNNAME_hs_code = "hs_code";

	/** Set hs_code	  */
	public void seths_code (String hs_code);

	/** Get hs_code	  */
	public String geths_code();

    /** Column name product_description */
    public static final String COLUMNNAME_product_description = "product_description";

	/** Set product_description	  */
	public void setproduct_description (String product_description);

	/** Get product_description	  */
	public String getproduct_description();

    /** Column name quantity */
    public static final String COLUMNNAME_quantity = "quantity";

	/** Set quantity	  */
	public void setquantity (BigDecimal quantity);

	/** Get quantity	  */
	public BigDecimal getquantity();

    /** Column name sale_type */
    public static final String COLUMNNAME_sale_type = "sale_type";

	/** Set sale_type	  */
	public void setsale_type (String sale_type);

	/** Get sale_type	  */
	public String getsale_type();

    /** Column name sales_tax_applicable */
    public static final String COLUMNNAME_sales_tax_applicable = "sales_tax_applicable";

	/** Set sales_tax_applicable	  */
	public void setsales_tax_applicable (BigDecimal sales_tax_applicable);

	/** Get sales_tax_applicable	  */
	public BigDecimal getsales_tax_applicable();

    /** Column name sales_tax_withheld_at_source */
    public static final String COLUMNNAME_sales_tax_withheld_at_source = "sales_tax_withheld_at_source";

	/** Set sales_tax_withheld_at_source	  */
	public void setsales_tax_withheld_at_source (BigDecimal sales_tax_withheld_at_source);

	/** Get sales_tax_withheld_at_source	  */
	public BigDecimal getsales_tax_withheld_at_source();

    /** Column name sro_item_serial_no */
    public static final String COLUMNNAME_sro_item_serial_no = "sro_item_serial_no";

	/** Set sro_item_serial_no	  */
	public void setsro_item_serial_no (String sro_item_serial_no);

	/** Get sro_item_serial_no	  */
	public String getsro_item_serial_no();

    /** Column name sro_schedule_no */
    public static final String COLUMNNAME_sro_schedule_no = "sro_schedule_no";

	/** Set sro_schedule_no	  */
	public void setsro_schedule_no (String sro_schedule_no);

	/** Get sro_schedule_no	  */
	public String getsro_schedule_no();

    /** Column name supply_destination */
    public static final String COLUMNNAME_supply_destination = "supply_destination";

	/** Set supply_destination	  */
	public void setsupply_destination (String supply_destination);

	/** Get supply_destination	  */
	public String getsupply_destination();

    /** Column name total_values */
    public static final String COLUMNNAME_total_values = "total_values";

	/** Set total_values	  */
	public void settotal_values (BigDecimal total_values);

	/** Get total_values	  */
	public BigDecimal gettotal_values();

    /** Column name uom */
    public static final String COLUMNNAME_uom = "uom";

	/** Set uom	  */
	public void setuom (String uom);

	/** Get uom	  */
	public String getuom();

    /** Column name value_sales_excluding_st */
    public static final String COLUMNNAME_value_sales_excluding_st = "value_sales_excluding_st";

	/** Set value_sales_excluding_st	  */
	public void setvalue_sales_excluding_st (BigDecimal value_sales_excluding_st);

	/** Get value_sales_excluding_st	  */
	public BigDecimal getvalue_sales_excluding_st();
}
