package com.planet_ink.coffee_mud.Locales;

import com.planet_ink.coffee_mud.interfaces.*;
import com.planet_ink.coffee_mud.common.*;
import java.util.*;

public class StoneRoom extends StdRoom
{
	public StoneRoom()
	{
		super();
		myID=this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.')+1);
		recoverEnvStats();
		domainType=Room.DOMAIN_INDOORS_STONE;
		domainCondition=Room.CONDITION_NORMAL;
	}
	public Environmental newInstance()
	{
		return new StoneRoom();
	}
	public static boolean isOkAffect(Room room, Affect affect)
	{
		return true;
	}
	public static void doAffect(Room room, Affect affect)
	{
	}
}
