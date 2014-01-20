package us.rdkl.pebblenotifier;

public class NotificationSourceTracker {
	private boolean visible;
	private String package_name;
	
	public NotificationSourceTracker(String sbn) {
		this.visible = true;
		this.package_name = sbn;
	}
	
	public boolean isVisible() {
		return this.visible;
	}
	
	public void setVisible(boolean v) {
		this.visible = v;
	}
	
	public String getPackageName() {
		return this.package_name;
	}
	
	public void setPackageName(String v) {
		this.package_name = v;
	}
	
	@Override
	public boolean equals(Object o) {
		return ((NotificationSourceTracker)o).getPackageName().equals(this.getPackageName());
	}
	
	@Override
	public int hashCode() {
		return this.getPackageName().hashCode();
	}
}
