package us.rdkl.pebblenotifier;

public class NotificationSetting {
	private boolean visible;
	private String package_name;
	
	public NotificationSetting(String sbn, boolean state) {
		this.visible = state;
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
		return ((NotificationSetting)o).getPackageName().equals(this.getPackageName());
	}
	
	@Override
	public int hashCode() {
		return this.getPackageName().hashCode();
	}
}
