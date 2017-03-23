package com.starfucker_inc.v1ch13.treeset;

import java.util.Objects;

class Item implements Comparable<Item>
{
    private String description;
    private int partNumber;

    public Item(String description, int partNumber)
    {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription()
    {
        return description;
    }

    public String toString()
    {
        return "[description=" + description + ", partNumber=" + partNumber +"]";
    }

    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }

    public int hashCode()
    {
        return Objects.hash(description, partNumber);
    }

    public int compareTo(Item other)
    {
        return Integer.compare(partNumber, other.partNumber);
    }
}