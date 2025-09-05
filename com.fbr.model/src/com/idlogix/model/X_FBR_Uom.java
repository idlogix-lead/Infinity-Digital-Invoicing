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

/** Generated Model for FBR_Uom
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="FBR_Uom")
public class X_FBR_Uom extends PO implements I_FBR_Uom, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250722L;

    /** Standard Constructor */
    public X_FBR_Uom (Properties ctx, int FBR_Uom_ID, String trxName)
    {
      super (ctx, FBR_Uom_ID, trxName);
      /** if (FBR_Uom_ID == 0)
        {
			setFBR_Uom_ID (0);
			setHS_Codes_ID (0);
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_FBR_Uom (Properties ctx, int FBR_Uom_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, FBR_Uom_ID, trxName, virtualColumns);
      /** if (FBR_Uom_ID == 0)
        {
			setFBR_Uom_ID (0);
			setHS_Codes_ID (0);
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_FBR_Uom (Properties ctx, String FBR_Uom_UU, String trxName)
    {
      super (ctx, FBR_Uom_UU, trxName);
      /** if (FBR_Uom_UU == null)
        {
			setFBR_Uom_ID (0);
			setHS_Codes_ID (0);
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_FBR_Uom (Properties ctx, String FBR_Uom_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, FBR_Uom_UU, trxName, virtualColumns);
      /** if (FBR_Uom_UU == null)
        {
			setFBR_Uom_ID (0);
			setHS_Codes_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_FBR_Uom (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_FBR_Uom[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set FBR_Uom.
		@param FBR_Uom_ID FBR_Uom
	*/
	public void setFBR_Uom_ID (int FBR_Uom_ID)
	{
		if (FBR_Uom_ID < 1)
			set_ValueNoCheck (COLUMNNAME_FBR_Uom_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_FBR_Uom_ID, Integer.valueOf(FBR_Uom_ID));
	}

	/** Get FBR_Uom.
		@return FBR_Uom	  */
	public int getFBR_Uom_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_FBR_Uom_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_HS_Codes getHS_Codes() throws RuntimeException
	{
		return (I_HS_Codes)MTable.get(getCtx(), I_HS_Codes.Table_ID)
			.getPO(getHS_Codes_ID(), get_TrxName());
	}

	/** Set HS_Codes_ID.
		@param HS_Codes_ID HS_Codes_ID
	*/
	public void setHS_Codes_ID (int HS_Codes_ID)
	{
		if (HS_Codes_ID < 1)
			set_ValueNoCheck (COLUMNNAME_HS_Codes_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_HS_Codes_ID, Integer.valueOf(HS_Codes_ID));
	}

	/** Get HS_Codes_ID.
		@return HS_Codes_ID	  */
	public int getHS_Codes_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HS_Codes_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}
}