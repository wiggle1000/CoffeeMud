package com.planet_ink.coffee_mud.interfaces;
import java.util.Calendar;

public interface Item extends Environmental
{
	public static int WORN_REQ_WORNONLY=0;
	public static int WORN_REQ_UNWORNONLY=1;
	public static int WORN_REQ_ANY=2;
	
	/** Where the item is located.  Either null for
	 * plain site (or contained on person), or will
	 * point to the container object*/
	public Item location();
	public void setLocation(Item newLocation);
	public Item ultimateLocation();
	
	public String secretIdentity();
	public String rawSecretIdentity();
	public void setSecretIdentity(String newIdentity);
	
	public boolean isAContainer();
	public boolean subjectToWearAndTear();
	
	/** If it applies, the number of uses remaining
	 * for this object */
	public int usesRemaining();
	public void setUsesRemaining(int newUses);
	
	public void destroyThis();
	public void removeThis();
	public boolean savable();
	
	public int value();
	public void setBaseValue(int newValue);
	
	public int capacity();
	public void setCapacity(int newValue);

	public int material();
	public void setMaterial(int newValue);

	public String readableText();
	public void setReadableText(String text);
	public boolean isReadable();
	public void setReadable(boolean isTrue);
	public boolean isGettable();
	public void setGettable(boolean isTrue);
	public boolean isDroppable();
	public void setDroppable(boolean isTrue);
	public boolean isRemovable();
	public void setRemovable(boolean isTrue);
	public boolean isTrapped();
	public void setTrapped(boolean isTrue);
	
	/**
	 * constants for worn items
	 */
	public static final long INVENTORY=0;
	public static final long ON_HEAD=1;
	public static final long ON_NECK=2;
	public static final long ON_TORSO=4;
	public static final long ON_ARMS=8;
	public static final long ON_LEFT_WRIST=16;
	public static final long ON_RIGHT_WRIST=32;
	public static final long ON_LEFT_FINGER=64;
	public static final long ON_RIGHT_FINGER=128;
	public static final long ON_FEET=256;
	public static final long HELD=512;
	public static final long WIELD=1024;
	public static final long ON_HANDS=2048;
	public static final long FLOATING_NEARBY=4096;
	public static final long ON_WAIST=8192;
	public static final long ON_LEGS=16384;
	
	public static final String[] wornLocation={
		"inventory",
		"head",
		"neck",
		"torso",
		"arms",
		"left wrist",
		"right wrist",
		"left finger",
		"right finger",
		"feet",
		"held",
		"wield",
		"hands",
		"floating nearby",
		"waist",
		"legs",
		"body"};
	
	/** If being worn, this code will show WHERE*/
	public boolean amWearingAt(long wornCode);	// 0 means in inventory! see above
	public boolean canBeWornAt(long wornCode);
	public long whereCantWear(MOB mob); // 0 == ok!
	public boolean canWear(MOB mob);
	public void wearIfPossible(MOB mob);
	public void wearAt(long wornCode);
	public void remove();
	public long rawWornCode();
	public long rawProperLocationBitmap();
	public void setRawProperLocationBitmap(long newValue);
	public boolean rawLogicalAnd();
	public void setRawLogicalAnd(boolean newAnd);
	public boolean compareProperLocations(Item toThis);
	
	public Environmental myOwner();
	public void setOwner(Environmental E);
	public Calendar possessionTime();
	public void setPossessionTime(Calendar time);
}
