package com.byteland.entity;

import java.util.ArrayList;
import java.util.List;

public class City {

	private int index;
	private boolean isUnified;
	private List<City> connectedCities;

	public City(int index, boolean isUnified) {
		this.index = index;
		this.isUnified = isUnified;
		connectedCities = new ArrayList<>();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isUnified() {
		return isUnified;
	}

	public boolean isNotUnified() {
		return !isUnified;
	}
	
	public void setUnified(boolean isUnified) {
		this.isUnified = isUnified;
	}

	public List<City> getConnectedCities() {
		return connectedCities;
	}

	public void setConnectedCities(List<City> connectedCities) {
		this.connectedCities = connectedCities;
	}
	
	public void addConnectedCity(City city) {
		connectedCities.add(city);
	}

	public int getConnectionsNum() {
		return connectedCities.size();
	}
	
	public void removeConnection(City city) {
		connectedCities.remove(city);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((connectedCities == null) ? 0 : connectedCities.hashCode());
		result = prime * result + index;
		result = prime * result + (isUnified ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (connectedCities == null) {
			if (other.connectedCities != null)
				return false;
		} else if (!connectedCities.equals(other.connectedCities))
			return false;
		if (index != other.index)
			return false;
		if (isUnified != other.isUnified)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("City [index=").append(index).append(", isUnified=").append(isUnified)
				.append(", connectedCities=").append(connectedCities).append("]");
		return builder.toString();
	}
	
}
