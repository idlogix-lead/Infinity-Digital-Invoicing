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

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for sap_fbr_credential
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="sap_fbr_credential")
public class X_sap_fbr_credential extends PO implements I_sap_fbr_credential, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250703L;

    /** Standard Constructor */
    public X_sap_fbr_credential (Properties ctx, int sap_fbr_credential_ID, String trxName)
    {
      super (ctx, sap_fbr_credential_ID, trxName);
      /** if (sap_fbr_credential_ID == 0)
        {
			setsap_fbr_credential_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sap_fbr_credential (Properties ctx, int sap_fbr_credential_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, sap_fbr_credential_ID, trxName, virtualColumns);
      /** if (sap_fbr_credential_ID == 0)
        {
			setsap_fbr_credential_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sap_fbr_credential (Properties ctx, String sap_fbr_credential_UU, String trxName)
    {
      super (ctx, sap_fbr_credential_UU, trxName);
      /** if (sap_fbr_credential_UU == null)
        {
			setsap_fbr_credential_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sap_fbr_credential (Properties ctx, String sap_fbr_credential_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, sap_fbr_credential_UU, trxName, virtualColumns);
      /** if (sap_fbr_credential_UU == null)
        {
			setsap_fbr_credential_ID (0);
        } */
    }

    /** Load Constructor */
    public X_sap_fbr_credential (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_sap_fbr_credential[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Fbr Api Url.
		@param fbr_api_url Fbr Api Url
	*/
	public void setfbr_api_url (String fbr_api_url)
	{
		set_Value (COLUMNNAME_fbr_api_url, fbr_api_url);
	}

	/** Get Fbr Api Url.
		@return Fbr Api Url	  */
	public String getfbr_api_url()
	{
		return (String)get_Value(COLUMNNAME_fbr_api_url);
	}

	/** Set Fbr Bearer Token.
		@param fbr_bearer_token Fbr Bearer Token
	*/
	public void setfbr_bearer_token (String fbr_bearer_token)
	{
		set_Value (COLUMNNAME_fbr_bearer_token, fbr_bearer_token);
	}

	/** Get Fbr Bearer Token.
		@return Fbr Bearer Token	  */
	public String getfbr_bearer_token()
	{
		return (String)get_Value(COLUMNNAME_fbr_bearer_token);
	}

	/** Set Sap Company Db.
		@param sap_company_db Sap Company Db
	*/
	public void setsap_company_db (String sap_company_db)
	{
		set_Value (COLUMNNAME_sap_company_db, sap_company_db);
	}

	/** Get Sap Company Db.
		@return Sap Company Db	  */
	public String getsap_company_db()
	{
		return (String)get_Value(COLUMNNAME_sap_company_db);
	}

	/** Set sap_fbr_credential.
		@param sap_fbr_credential_ID sap_fbr_credential
	*/
	public void setsap_fbr_credential_ID (int sap_fbr_credential_ID)
	{
		if (sap_fbr_credential_ID < 1)
			set_ValueNoCheck (COLUMNNAME_sap_fbr_credential_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_sap_fbr_credential_ID, Integer.valueOf(sap_fbr_credential_ID));
	}

	/** Get sap_fbr_credential.
		@return sap_fbr_credential	  */
	public int getsap_fbr_credential_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sap_fbr_credential_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Sap Invoice Url.
		@param sap_invoice_url Sap Invoice Url
	*/
	public void setsap_invoice_url (String sap_invoice_url)
	{
		set_Value (COLUMNNAME_sap_invoice_url, sap_invoice_url);
	}

	/** Get Sap Invoice Url.
		@return Sap Invoice Url	  */
	public String getsap_invoice_url()
	{
		return (String)get_Value(COLUMNNAME_sap_invoice_url);
	}

	/** Set Sap Login Url.
		@param sap_login_url Sap Login Url
	*/
	public void setsap_login_url (String sap_login_url)
	{
		set_Value (COLUMNNAME_sap_login_url, sap_login_url);
	}

	/** Get Sap Login Url.
		@return Sap Login Url	  */
	public String getsap_login_url()
	{
		return (String)get_Value(COLUMNNAME_sap_login_url);
	}

	/** Set Sap Password.
		@param sap_password Sap Password
	*/
	public void setsap_password (String sap_password)
	{
		set_Value (COLUMNNAME_sap_password, sap_password);
	}

	/** Get Sap Password.
		@return Sap Password	  */
	public String getsap_password()
	{
		return (String)get_Value(COLUMNNAME_sap_password);
	}

	/** Set Sap Username.
		@param sap_username Sap Username
	*/
	public void setsap_username (String sap_username)
	{
		set_Value (COLUMNNAME_sap_username, sap_username);
	}

	/** Get Sap Username.
		@return Sap Username	  */
	public String getsap_username()
	{
		return (String)get_Value(COLUMNNAME_sap_username);
	}

	/** Set Seller Address.
		@param seller_address Seller Address
	*/
	public void setseller_address (String seller_address)
	{
		set_Value (COLUMNNAME_seller_address, seller_address);
	}

	/** Get Seller Address.
		@return Seller Address	  */
	public String getseller_address()
	{
		return (String)get_Value(COLUMNNAME_seller_address);
	}

	/** Set Seller Business Name.
		@param seller_business_name Seller Business Name
	*/
	public void setseller_business_name (String seller_business_name)
	{
		set_Value (COLUMNNAME_seller_business_name, seller_business_name);
	}

	/** Get Seller Business Name.
		@return Seller Business Name	  */
	public String getseller_business_name()
	{
		return (String)get_Value(COLUMNNAME_seller_business_name);
	}

	/** Set Seller NTN/CNIC.
		@param seller_ntn_cnic Seller NTN/CNIC
	*/
	public void setseller_ntn_cnic (String seller_ntn_cnic)
	{
		set_Value (COLUMNNAME_seller_ntn_cnic, seller_ntn_cnic);
	}

	/** Get Seller NTN/CNIC.
		@return Seller NTN/CNIC	  */
	public String getseller_ntn_cnic()
	{
		return (String)get_Value(COLUMNNAME_seller_ntn_cnic);
	}

	/** Set Seller Province.
		@param seller_province Seller Province
	*/
	public void setseller_province (String seller_province)
	{
		set_Value (COLUMNNAME_seller_province, seller_province);
	}

	/** Get Seller Province.
		@return Seller Province	  */
	public String getseller_province()
	{
		return (String)get_Value(COLUMNNAME_seller_province);
	}
}