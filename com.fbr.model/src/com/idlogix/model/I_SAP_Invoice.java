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

/** Generated Interface for SAP_Invoice
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_SAP_Invoice 
{

    /** TableName=SAP_Invoice */
    public static final String Table_Name = "SAP_Invoice";

    /** AD_Table_ID=1000002 */
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

    /** Column name Address */
    public static final String COLUMNNAME_Address = "Address";

	/** Set Address	  */
	public void setAddress (String Address);

	/** Get Address	  */
	public String getAddress();

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

    /** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";

	/** Set Document No.
	  * Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo);

	/** Get Document No.
	  * Document sequence number of the document
	  */
	public String getDocumentNo();

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

    /** Column name IsValid */
    public static final String COLUMNNAME_IsValid = "IsValid";

	/** Set Valid.
	  * Element is valid
	  */
	public void setIsValid (boolean IsValid);

	/** Get Valid.
	  * Element is valid
	  */
	public boolean isValid();

    /** Column name SAP_Invoice_ID */
    public static final String COLUMNNAME_SAP_Invoice_ID = "SAP_Invoice_ID";

	/** Set SAP_Invoice_ID	  */
	public void setSAP_Invoice_ID (int SAP_Invoice_ID);

	/** Get SAP_Invoice_ID	  */
	public int getSAP_Invoice_ID();

    /** Column name TotalAmt */
    public static final String COLUMNNAME_TotalAmt = "TotalAmt";

	/** Set Total Amount.
	  * Total Amount
	  */
	public void setTotalAmt (BigDecimal TotalAmt);

	/** Get Total Amount.
	  * Total Amount
	  */
	public BigDecimal getTotalAmt();

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

    /** Column name buyer_address */
    public static final String COLUMNNAME_buyer_address = "buyer_address";

	/** Set buyer_address	  */
	public void setbuyer_address (String buyer_address);

	/** Get buyer_address	  */
	public String getbuyer_address();

    /** Column name buyer_business_name */
    public static final String COLUMNNAME_buyer_business_name = "buyer_business_name";

	/** Set buyer_business_name	  */
	public void setbuyer_business_name (String buyer_business_name);

	/** Get buyer_business_name	  */
	public String getbuyer_business_name();

    /** Column name buyer_ntn_cnic */
    public static final String COLUMNNAME_buyer_ntn_cnic = "buyer_ntn_cnic";

	/** Set buyer_ntn_cnic	  */
	public void setbuyer_ntn_cnic (String buyer_ntn_cnic);

	/** Get buyer_ntn_cnic	  */
	public String getbuyer_ntn_cnic();

    /** Column name buyer_province */
    public static final String COLUMNNAME_buyer_province = "buyer_province";

	/** Set Buyer Province	  */
	public void setbuyer_province (String buyer_province);

	/** Get Buyer Province	  */
	public String getbuyer_province();

    /** Column name buyer_registration_type */
    public static final String COLUMNNAME_buyer_registration_type = "buyer_registration_type";

	/** Set Buyer Registration Type	  */
	public void setbuyer_registration_type (String buyer_registration_type);

	/** Get Buyer Registration Type	  */
	public String getbuyer_registration_type();

    /** Column name city_code */
    public static final String COLUMNNAME_city_code = "city_code";

	/** Set city_code	  */
	public void setcity_code (String city_code);

	/** Get city_code	  */
	public String getcity_code();

    /** Column name doc_entry_no */
    public static final String COLUMNNAME_doc_entry_no = "doc_entry_no";

	/** Set doc_entry_no	  */
	public void setdoc_entry_no (String doc_entry_no);

	/** Get doc_entry_no	  */
	public String getdoc_entry_no();

    /** Column name fbr_error_msg */
    public static final String COLUMNNAME_fbr_error_msg = "fbr_error_msg";

	/** Set Fbr Error Message.
	  * Fbr Error Message
	  */
	public void setfbr_error_msg (String fbr_error_msg);

	/** Get Fbr Error Message.
	  * Fbr Error Message
	  */
	public String getfbr_error_msg();

    /** Column name fbr_invoice_no */
    public static final String COLUMNNAME_fbr_invoice_no = "fbr_invoice_no";

	/** Set Fbr Invoice No	  */
	public void setfbr_invoice_no (String fbr_invoice_no);

	/** Get Fbr Invoice No	  */
	public String getfbr_invoice_no();

    /** Column name invoice_date */
    public static final String COLUMNNAME_invoice_date = "invoice_date";

	/** Set invoice_date	  */
	public void setinvoice_date (Timestamp invoice_date);

	/** Get invoice_date	  */
	public Timestamp getinvoice_date();

    /** Column name invoice_ref_no */
    public static final String COLUMNNAME_invoice_ref_no = "invoice_ref_no";

	/** Set invoice_ref_no	  */
	public void setinvoice_ref_no (String invoice_ref_no);

	/** Get invoice_ref_no	  */
	public String getinvoice_ref_no();

    /** Column name invoice_type */
    public static final String COLUMNNAME_invoice_type = "invoice_type";

	/** Set Invoice Type	  */
	public void setinvoice_type (String invoice_type);

	/** Get Invoice Type	  */
	public String getinvoice_type();

    /** Column name isSAPUpdated */
    public static final String COLUMNNAME_isSAPUpdated = "isSAPUpdated";

	/** Set isSAPUpdated	  */
	public void setisSAPUpdated (boolean isSAPUpdated);

	/** Get isSAPUpdated	  */
	public boolean isSAPUpdated();

    /** Column name province_code */
    public static final String COLUMNNAME_province_code = "province_code";

	/** Set Province Code	  */
	public void setprovince_code (String province_code);

	/** Get Province Code	  */
	public String getprovince_code();

    /** Column name scenario_id */
    public static final String COLUMNNAME_scenario_id = "scenario_id";

	/** Set scenario_id	  */
	public void setscenario_id (String scenario_id);

	/** Get scenario_id	  */
	public String getscenario_id();

    /** Column name seller_address */
    public static final String COLUMNNAME_seller_address = "seller_address";

	/** Set seller_address	  */
	public void setseller_address (String seller_address);

	/** Get seller_address	  */
	public String getseller_address();

    /** Column name seller_business_name */
    public static final String COLUMNNAME_seller_business_name = "seller_business_name";

	/** Set seller_business_name	  */
	public void setseller_business_name (String seller_business_name);

	/** Get seller_business_name	  */
	public String getseller_business_name();

    /** Column name seller_ntn_cnic */
    public static final String COLUMNNAME_seller_ntn_cnic = "seller_ntn_cnic";

	/** Set seller_ntn_cnic	  */
	public void setseller_ntn_cnic (String seller_ntn_cnic);

	/** Get seller_ntn_cnic	  */
	public String getseller_ntn_cnic();

    /** Column name seller_province */
    public static final String COLUMNNAME_seller_province = "seller_province";

	/** Set seller_province	  */
	public void setseller_province (String seller_province);

	/** Get seller_province	  */
	public String getseller_province();
}
