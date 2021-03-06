package device;

import java.io.IOException;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class DevicePanel extends JPanel {

	public abstract void setDevice(TunerController fcd) throws IOException, DeviceException;
	
	public abstract void updateFilter() throws IOException, DeviceException;
	
	public abstract void setEnabled(boolean b);
	
	public abstract int getSampleRate();
	public abstract int getDecimationRate();

}
