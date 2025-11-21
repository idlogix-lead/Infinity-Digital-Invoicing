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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for SAP_Invoice
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="SAP_Invoice")
public class X_SAP_Invoice extends PO implements I_SAP_Invoice, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250909L;

    /** Standard Constructor */
    public X_SAP_Invoice (Properties ctx, int SAP_Invoice_ID, String trxName)
    {
      super (ctx, SAP_Invoice_ID, trxName);
      /** if (SAP_Invoice_ID == 0)
        {
			setIsValid (false);
// N
			setSAP_Invoice_ID (0);
			setisSAPUpdated (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_SAP_Invoice (Properties ctx, int SAP_Invoice_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, SAP_Invoice_ID, trxName, virtualColumns);
      /** if (SAP_Invoice_ID == 0)
        {
			setIsValid (false);
// N
			setSAP_Invoice_ID (0);
			setisSAPUpdated (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_SAP_Invoice (Properties ctx, String SAP_Invoice_UU, String trxName)
    {
      super (ctx, SAP_Invoice_UU, trxName);
      /** if (SAP_Invoice_UU == null)
        {
			setIsValid (false);
// N
			setSAP_Invoice_ID (0);
			setisSAPUpdated (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_SAP_Invoice (Properties ctx, String SAP_Invoice_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, SAP_Invoice_UU, trxName, virtualColumns);
      /** if (SAP_Invoice_UU == null)
        {
			setIsValid (false);
// N
			setSAP_Invoice_ID (0);
			setisSAPUpdated (false);
// N
        } */
    }

    /** Load Constructor */
    public X_SAP_Invoice (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_SAP_Invoice[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Address.
		@param Address Address
	*/
	public void setAddress (String Address)
	{
		set_ValueNoCheck (COLUMNNAME_Address, Address);
	}

	/** Get Address.
		@return Address	  */
	public String getAddress()
	{
		return (String)get_Value(COLUMNNAME_Address);
	}

	/** Set Document No.
		@param DocumentNo Document sequence number of the document
	*/
	public void setDocumentNo (String DocumentNo)
	{
		set_Value (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo()
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set Valid.
		@param IsValid Element is valid
	*/
	public void setIsValid (boolean IsValid)
	{
		set_Value (COLUMNNAME_IsValid, Boolean.valueOf(IsValid));
	}

	/** Get Valid.
		@return Element is valid
	  */
	public boolean isValid()
	{
		Object oo = get_Value(COLUMNNAME_IsValid);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Total Amount.
		@param TotalAmt Total Amount
	*/
	public void setTotalAmt (BigDecimal TotalAmt)
	{
		set_Value (COLUMNNAME_TotalAmt, TotalAmt);
	}

	/** Get Total Amount.
		@return Total Amount
	  */
	public BigDecimal getTotalAmt()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TotalAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set buyer_address.
		@param buyer_address buyer_address
	*/
	public void setbuyer_address (String buyer_address)
	{
		set_Value (COLUMNNAME_buyer_address, buyer_address);
	}

	/** Get buyer_address.
		@return buyer_address	  */
	public String getbuyer_address()
	{
		return (String)get_Value(COLUMNNAME_buyer_address);
	}

	/** Set buyer_business_name.
		@param buyer_business_name buyer_business_name
	*/
	public void setbuyer_business_name (String buyer_business_name)
	{
		set_Value (COLUMNNAME_buyer_business_name, buyer_business_name);
	}

	/** Get buyer_business_name.
		@return buyer_business_name	  */
	public String getbuyer_business_name()
	{
		return (String)get_Value(COLUMNNAME_buyer_business_name);
	}

	/** Set buyer_ntn_cnic.
		@param buyer_ntn_cnic buyer_ntn_cnic
	*/
	public void setbuyer_ntn_cnic (String buyer_ntn_cnic)
	{
		set_Value (COLUMNNAME_buyer_ntn_cnic, buyer_ntn_cnic);
	}

	/** Get buyer_ntn_cnic.
		@return buyer_ntn_cnic	  */
	public String getbuyer_ntn_cnic()
	{
		return (String)get_Value(COLUMNNAME_buyer_ntn_cnic);
	}

	/** AZAD JAMMU AND KASHMIR = AZAD JAMMU AND KASHMIR */
	public static final String BUYER_PROVINCE_AZADJAMMUANDKASHMIR = "AZAD JAMMU AND KASHMIR";
	/** BALOCHISTAN = BALOCHISTAN */
	public static final String BUYER_PROVINCE_BALOCHISTAN = "BALOCHISTAN";
	/** CAPITAL TERRITORY = CAPITAL TERRITORY */
	public static final String BUYER_PROVINCE_CAPITALTERRITORY = "CAPITAL TERRITORY";
	/** GILGIT BALTISTAN = GILGIT BALTISTAN */
	public static final String BUYER_PROVINCE_GILGITBALTISTAN = "GILGIT BALTISTAN";
	/** KHYBER PAKHTUNKHWA = KHYBER PAKHTUNKHWA */
	public static final String BUYER_PROVINCE_KHYBERPAKHTUNKHWA = "KHYBER PAKHTUNKHWA";
	/** PUNJAB = PUNJAB */
	public static final String BUYER_PROVINCE_PUNJAB = "PUNJAB";
	/** SINDH = SINDH */
	public static final String BUYER_PROVINCE_SINDH = "SINDH";
	/** Set Buyer Province.
		@param buyer_province Buyer Province
	*/
	public void setbuyer_province (String buyer_province)
	{

		set_Value (COLUMNNAME_buyer_province, buyer_province);
	}

	/** Get Buyer Province.
		@return Buyer Province	  */
	public String getbuyer_province()
	{
		return (String)get_Value(COLUMNNAME_buyer_province);
	}

	/** Registered = Registered */
	public static final String BUYER_REGISTRATION_TYPE_Registered = "Registered";
	/** Unregistered = Unregistered */
	public static final String BUYER_REGISTRATION_TYPE_Unregistered = "Unregistered";
	/** Set Buyer Registration Type.
		@param buyer_registration_type Buyer Registration Type
	*/
	public void setbuyer_registration_type (String buyer_registration_type)
	{

		set_Value (COLUMNNAME_buyer_registration_type, buyer_registration_type);
	}

	/** Get Buyer Registration Type.
		@return Buyer Registration Type	  */
	public String getbuyer_registration_type()
	{
		return (String)get_Value(COLUMNNAME_buyer_registration_type);
	}

	/** Set city_code.
		@param city_code city_code
	*/
	public void setcity_code (String city_code)
	{
		set_Value (COLUMNNAME_city_code, city_code);
	}

	/** Get city_code.
		@return city_code	  */
	public String getcity_code()
	{
		return (String)get_Value(COLUMNNAME_city_code);
	}

	/** Set doc_entry_no.
		@param doc_entry_no doc_entry_no
	*/
	public void setdoc_entry_no (String doc_entry_no)
	{
		set_Value (COLUMNNAME_doc_entry_no, doc_entry_no);
	}

	/** Get doc_entry_no.
		@return doc_entry_no	  */
	public String getdoc_entry_no()
	{
		return (String)get_Value(COLUMNNAME_doc_entry_no);
	}

	/** Set Fbr Error Message.
		@param fbr_error_msg Fbr Error Message
	*/
	public void setfbr_error_msg (String fbr_error_msg)
	{
		set_Value (COLUMNNAME_fbr_error_msg, fbr_error_msg);
	}

	/** Get Fbr Error Message.
		@return Fbr Error Message
	  */
	public String getfbr_error_msg()
	{
		return (String)get_Value(COLUMNNAME_fbr_error_msg);
	}

	/** Set Fbr Invoice No.
		@param fbr_invoice_no Fbr Invoice No
	*/
	public void setfbr_invoice_no (String fbr_invoice_no)
	{
		set_Value (COLUMNNAME_fbr_invoice_no, fbr_invoice_no);
	}

	/** Get Fbr Invoice No.
		@return Fbr Invoice No	  */
	public String getfbr_invoice_no()
	{
		return (String)get_Value(COLUMNNAME_fbr_invoice_no);
	}

	/** Set invoice_date.
		@param invoice_date invoice_date
	*/
	public void setinvoice_date (Timestamp invoice_date)
	{
		set_Value (COLUMNNAME_invoice_date, invoice_date);
	}

	/** Get invoice_date.
		@return invoice_date	  */
	public Timestamp getinvoice_date()
	{
		return (Timestamp)get_Value(COLUMNNAME_invoice_date);
	}

	/** Set invoice_ref_no.
		@param invoice_ref_no invoice_ref_no
	*/
	public void setinvoice_ref_no (String invoice_ref_no)
	{
		set_Value (COLUMNNAME_invoice_ref_no, invoice_ref_no);
	}

	/** Get invoice_ref_no.
		@return invoice_ref_no	  */
	public String getinvoice_ref_no()
	{
		return (String)get_Value(COLUMNNAME_invoice_ref_no);
	}

	/** Debit Note = Debit Note */
	public static final String INVOICE_TYPE_DebitNote = "Debit Note";
	/** Sale Invoice = Sale Invoice */
	public static final String INVOICE_TYPE_SaleInvoice = "Sale Invoice";
	/** Set Invoice Type.
		@param invoice_type Invoice Type
	*/
	public void setinvoice_type (String invoice_type)
	{

		set_Value (COLUMNNAME_invoice_type, invoice_type);
	}

	/** Get Invoice Type.
		@return Invoice Type	  */
	public String getinvoice_type()
	{
		return (String)get_Value(COLUMNNAME_invoice_type);
	}

	/** Set isSAPUpdated.
		@param isSAPUpdated isSAPUpdated
	*/
	public void setisSAPUpdated (boolean isSAPUpdated)
	{
		set_Value (COLUMNNAME_isSAPUpdated, Boolean.valueOf(isSAPUpdated));
	}

	/** Get isSAPUpdated.
		@return isSAPUpdated	  */
	public boolean isSAPUpdated()
	{
		Object oo = get_Value(COLUMNNAME_isSAPUpdated);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** 2 = 2 */
	public static final String PROVINCE_CODE_2 = "2";
	/** 4 = 4 */
	public static final String PROVINCE_CODE_4 = "4";
	/** 5 = 5 */
	public static final String PROVINCE_CODE_5 = "5";
	/** 6 = 6 */
	public static final String PROVINCE_CODE_6 = "6";
	/** 7 = 7 */
	public static final String PROVINCE_CODE_7 = "7";
	/** 8 = 8 */
	public static final String PROVINCE_CODE_8 = "8";
	/** 9 = 9 */
	public static final String PROVINCE_CODE_9 = "9";
	/** Set Province Code.
		@param province_code Province Code
	*/
	public void setprovince_code (String province_code)
	{

		set_Value (COLUMNNAME_province_code, province_code);
	}

	/** Get Province Code.
		@return Province Code	  */
	public String getprovince_code()
	{
		return (String)get_Value(COLUMNNAME_province_code);
	}

	/** SN000 = SN000 */
	public static final String SCENARIO_ID_SN000 = "SN000";
	/** SN001 = SN001 */
	public static final String SCENARIO_ID_SN001 = "SN001";
	/** SN002 = SN002 */
	public static final String SCENARIO_ID_SN002 = "SN002";
	/** SN003 = SN003 */
	public static final String SCENARIO_ID_SN003 = "SN003";
	/** SN004 = SN004 */
	public static final String SCENARIO_ID_SN004 = "SN004";
	/** SN005 = SN005 */
	public static final String SCENARIO_ID_SN005 = "SN005";
	/** SN006 = SN006 */
	public static final String SCENARIO_ID_SN006 = "SN006";
	/** SN007 = SN007 */
	public static final String SCENARIO_ID_SN007 = "SN007";
	/** SN008 = SN008 */
	public static final String SCENARIO_ID_SN008 = "SN008";
	/** SN009 = SN009 */
	public static final String SCENARIO_ID_SN009 = "SN009";
	/** SN010 = SN010 */
	public static final String SCENARIO_ID_SN010 = "SN010";
	/** SN011 = SN011 */
	public static final String SCENARIO_ID_SN011 = "SN011";
	/** SN012 = SN012 */
	public static final String SCENARIO_ID_SN012 = "SN012";
	/** SN013 = SN013 */
	public static final String SCENARIO_ID_SN013 = "SN013";
	/** SN014 = SN014 */
	public static final String SCENARIO_ID_SN014 = "SN014";
	/** SN015 = SN015 */
	public static final String SCENARIO_ID_SN015 = "SN015";
	/** SN016 = SN016 */
	public static final String SCENARIO_ID_SN016 = "SN016";
	/** SN017 = SN017 */
	public static final String SCENARIO_ID_SN017 = "SN017";
	/** SN018 = SN018 */
	public static final String SCENARIO_ID_SN018 = "SN018";
	/** SN019 = SN019 */
	public static final String SCENARIO_ID_SN019 = "SN019";
	/** SN020 = SN020 */
	public static final String SCENARIO_ID_SN020 = "SN020";
	/** SN021 = SN021 */
	public static final String SCENARIO_ID_SN021 = "SN021";
	/** SN022 = SN022 */
	public static final String SCENARIO_ID_SN022 = "SN022";
	/** SN023 = SN023 */
	public static final String SCENARIO_ID_SN023 = "SN023";
	/** SN024 = SN024 */
	public static final String SCENARIO_ID_SN024 = "SN024";
	/** Set scenario_id.
		@param scenario_id scenario_id
	*/
	public void setscenario_id (String scenario_id)
	{

		set_Value (COLUMNNAME_scenario_id, scenario_id);
	}

	/** Get scenario_id.
		@return scenario_id	  */
	public String getscenario_id()
	{
		return (String)get_Value(COLUMNNAME_scenario_id);
	}

	/** Set seller_address.
		@param seller_address seller_address
	*/
	public void setseller_address (String seller_address)
	{
		set_Value (COLUMNNAME_seller_address, seller_address);
	}

	/** Get seller_address.
		@return seller_address	  */
	public String getseller_address()
	{
		return (String)get_Value(COLUMNNAME_seller_address);
	}

	/** Set seller_business_name.
		@param seller_business_name seller_business_name
	*/
	public void setseller_business_name (String seller_business_name)
	{
		set_Value (COLUMNNAME_seller_business_name, seller_business_name);
	}

	/** Get seller_business_name.
		@return seller_business_name	  */
	public String getseller_business_name()
	{
		return (String)get_Value(COLUMNNAME_seller_business_name);
	}

	/** Set seller_ntn_cnic.
		@param seller_ntn_cnic seller_ntn_cnic
	*/
	public void setseller_ntn_cnic (String seller_ntn_cnic)
	{
		set_Value (COLUMNNAME_seller_ntn_cnic, seller_ntn_cnic);
	}

	/** Get seller_ntn_cnic.
		@return seller_ntn_cnic	  */
	public String getseller_ntn_cnic()
	{
		return (String)get_Value(COLUMNNAME_seller_ntn_cnic);
	}

	/** Set seller_province.
		@param seller_province seller_province
	*/
	public void setseller_province (String seller_province)
	{
		set_Value (COLUMNNAME_seller_province, seller_province);
	}

	/** Get seller_province.
		@return seller_province	  */
	public String getseller_province()
	{
		return (String)get_Value(COLUMNNAME_seller_province);
	}
}