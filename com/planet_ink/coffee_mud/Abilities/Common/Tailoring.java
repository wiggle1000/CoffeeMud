package com.planet_ink.coffee_mud.Abilities.Common;

import com.planet_ink.coffee_mud.interfaces.*;
import com.planet_ink.coffee_mud.common.*;
import com.planet_ink.coffee_mud.utils.*;
import java.util.*;

public class Tailoring extends CommonSkill
{
	private Item building=null;
	public Tailoring()
	{
		super();
		myID=this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.')+1);
		name="Tailoring";

		miscText="";
		triggerStrings.addElement("KNIT");
		triggerStrings.addElement("TAILOR");
		triggerStrings.addElement("TAILORING");
		quality=Ability.INDIFFERENT;

		recoverEnvStats();
		//CMAble.addCharAbilityMapping("All",1,ID(),false);
	}
	
	public Environmental newInstance()
	{
		return new Tailoring();
	}
	
	public boolean tick(int tickID)
	{
		if((affected!=null)&&(affected instanceof MOB)&&(tickID==Host.MOB_TICK))
		{
			MOB mob=(MOB)affected;
			if(building==null)
				unInvoke();
			else
			if(tickUp==0)
			{
				mob.tell("You start knitting "+building.name()+".");
				displayText="You are knitting "+building.name();
				verb="knitting "+building.name();
			}
		}
		return super.tick(tickID);
	}
	
	public void unInvoke()
	{
		if((affected!=null)&&(affected instanceof MOB))
		{
			MOB mob=(MOB)affected;
			if(building!=null)
				mob.location().addItem(building);
			building=null;
		}
		super.unInvoke();
	}
	
	public boolean invoke(MOB mob, Vector commands, Environmental givenTarget, boolean auto)
	{
		if(commands.size()==0)
		{
			mob.tell("Knit what? Enter \"knit list\" for a list.");
			return false;
		}
		if(!super.invoke(mob,commands,givenTarget,auto))
			return false;
		
		String name=Util.combine(commands,0);
		int profficiencyAdjustment=0;
		int completion=6;
		if(completion<4) completion=4;
		FullMsg msg=new FullMsg(mob,null,Affect.MSG_NOISYMOVEMENT,null);
		if(mob.location().okAffect(msg))
		{
			mob.location().send(mob,msg);
			beneficialAffect(mob,mob,completion);
		}
		return true;
	}
}
