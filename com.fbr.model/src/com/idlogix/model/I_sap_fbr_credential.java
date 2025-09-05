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

/** Generated Interface for sap_fbr_credential
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_sap_fbr_credential 
{

    /** TableName=sap_fbr_credential */
    public static final String Table_Name = "sap_fbr_credential";

    /** AD_Table_ID=1000004 */
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

    /** Column name fbr_api_url */
    public static final String COLUMNNAME_fbr_api_url = "fbr_api_url";

	/** Set Fbr Api Url	  */
	public void setfbr_api_url (String fbr_api_url);

	/** Get Fbr Api Url	  */
	public String getfbr_api_url();

    /** Column name fbr_bearer_token */
    public static final String COLUMNNAME_fbr_bearer_token = "fbr_bearer_token";

	/** Set Fbr Bearer Token	  */
	public void setfbr_bearer_token (String fbr_bearer_token);

	/** Get Fbr Bearer Token	  */
	public String getfbr_bearer_token();

    /** Column name sap_company_db */
    public static final String COLUMNNAME_sap_company_db = "sap_company_db";

	/** Set Sap Company Db	  */
	public void setsap_company_db (String sap_company_db);

	/** Get Sap Company Db	  */
	public String getsap_company_db();

    /** Column name sap_fbr_credential_ID */
    public static final String COLUMNNAME_sap_fbr_credential_ID = "sap_fbr_credential_ID";

	/** Set sap_fbr_credential	  */
	public void setsap_fbr_credential_ID (int sap_fbr_credential_ID);

	/** Get sap_fbr_credential	  */
	public int getsap_fbr_credential_ID();

    /** Column name sap_invoice_url */
    public static final String COLUMNNAME_sap_invoice_url = "sap_invoice_url";

	/** Set Sap Invoice Url	  */
	public void setsap_invoice_url (String sap_invoice_url);

	/** Get Sap Invoice Url	  */
	public String getsap_invoice_url();

    /** Column name sap_login_url */
    public static final String COLUMNNAME_sap_login_url = "sap_login_url";

	/** Set Sap Login Url	  */
	public void setsap_login_url (String sap_login_url);

	/** Get Sap Login Url	  */
	public String getsap_login_url();

    /** Column name sap_password */
    public static final String COLUMNNAME_sap_password = "sap_password";

	/** Set Sap Password	  */
	public void setsap_password (String sap_password);

	/** Get Sap Password	  */
	public String getsap_password();

    /** Column name sap_username */
    public static final String COLUMNNAME_sap_username = "sap_username";

	/** Set Sap Username	  */
	public void setsap_username (String sap_username);

	/** Get Sap Username	  */
	public String getsap_username();

    /** Column name seller_address */
    public static final String COLUMNNAME_seller_address = "seller_address";

	/** Set Seller Address	  */
	public void setseller_address (String seller_address);

	/** Get Seller Address	  */
	public String getseller_address();

    /** Column name seller_business_name */
    public static final String COLUMNNAME_seller_business_name = "seller_business_name";

	/** Set Seller Business Name	  */
	public void setseller_business_name (String seller_business_name);

	/** Get Seller Business Name	  */
	public String getseller_business_name();

    /** Column name seller_ntn_cnic */
    public static final String COLUMNNAME_seller_ntn_cnic = "seller_ntn_cnic";

	/** Set Seller NTN/CNIC	  */
	public void setseller_ntn_cnic (String seller_ntn_cnic);

	/** Get Seller NTN/CNIC	  */
	public String getseller_ntn_cnic();

    /** Column name seller_province */
    public static final String COLUMNNAME_seller_province = "seller_province";

	/** Set Seller Province	  */
	public void setseller_province (String seller_province);

	/** Get Seller Province	  */
	public String getseller_province();
}
