package telemetry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import common.Config;
import common.Spacecraft;
import decoder.FoxDecoder;

/**
 * 
 * FOX 1 Telemetry Decoder
 * @author chris.e.thompson g0kla/ac2cz
 *
 * Copyright (C) 2015 amsat.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
public class PayloadRtValues extends FramePart {

	//public static final int NUMBER_OF_FIELDS = 43;
	
	public PayloadRtValues(BitArrayLayout lay) {
		super(lay);
	}
	
	public PayloadRtValues(ResultSet r, BitArrayLayout lay) throws SQLException {
		super(r, lay);
	}
	
	public PayloadRtValues(int id, int resets, long uptime, String date, StringTokenizer st, BitArrayLayout lay) {
		super(id, resets, uptime, date, st, lay);	
	}

	protected void init() {
		type = TYPE_REAL_TIME;
		fieldValue = new int[layout.NUMBER_OF_FIELDS];
	}
	
	public String toWebString() {
		
		///// NEED TO DO THIS BY LOOPING THROUGH THE LAYOUT AND SUPPORT RAW / CONVERTED
		
		//copyBitsToFields(); // dont need this as we loaded from the DB for the Web service
		
		Spacecraft fox = Config.satManager.getSpacecraft(id);
		String s = new String();
		s = s + "<h3>Fox "+ fox.getIdString()+"  REAL TIME Telemetry   Reset: " + resets + " Uptime: " + uptime + "</h3>"
				+ "<table>"
				
				+ "<tr bgcolor=silver>"
				+ "<td><h3>Radio</h3>"
				+ "</td>"
				+ "<td><h3>Computer</h3>"
				+ "</td>"
				+ "<td><h3>Battery</h3>"
				+ "</td>"
				+ "</tr>"

				+ "<tr>"
				+ "<td>"
				+ "TXPACurrent: " + getStringValue("TXPACurrent", fox)  + "<br>" 
				+ " TXTemperature: " + getStringValue("TXTemperature", fox) + "<br>" 
				
				+ "RXTemperature: " + getStringValue("RXTemperature", fox)  + "<br>" 
				+ " RSSI: " + getStringValue("RSSI", fox) + "<br>" 
				+ "\n" + "<br>" 
				+ " AntennaDeploySensors: " + getStringValue("RXAntenna", fox) + " "
				+ getStringValue("TXAntenna", fox) + "<br>" 
				
				+ "</td>"
				
				+ "<td>"
				+ "IHUTemperature: " + getStringValue("IHUTemperature", fox) + "<br>"
				+ " SPIN: " + getStringValue("SPIN", fox)+ "<br>"
				+ "IHUDiagnosticData: " + getStringValue("IHUDiagnosticData", fox) + "<br>"
				+ "SystemI2CFailureIndications: " + getStringValue("BATTI2CFailureIndications", fox) + " "
				+ getStringValue("PSU1I2CFailureIndications", fox) + " "
				+ getStringValue("PSU2I2CFailureIndications", fox) + " "
				+ "\n" + "<br>"
				+ "NumberofGroundCommandedTLMResets: " + getStringValue("NumberofGroundCommandedTLMResets", fox)
				
				+ "</td>"
				
				+ "<td>"
				+ "BATT_A_V: " + getStringValue("BATT_A_V", fox) + "<br>" 
				+ " BATT_B_V: " + getStringValue("BATT_B_V", fox) + "<br>" 
				+ " BATT_C_V: " + getStringValue("BATT_C_V", fox) + "<br>"
				+ "\n"
				+ "BATT_A_T: " + getStringValue("BATT_A_T", fox)  + "<br>"
				+ " BATT_B_T: " + getStringValue("BATT_B_T", fox) + "<br>"
				+ " BATT_C_T: " + getStringValue("BATT_C_T", fox) + "<br>"
				+ "\n" + "<br>"
				+ "TOTAL_BATT_I: " + getStringValue("TOTAL_BATT_I", fox)  + "<br>"
				+ " BATTBoardTemperature: " + getStringValue("BATTBoardTemperature", fox) + "<br>"

				+ "</td>"
				+ "</tr>"
				
				+ "<tr bgcolor=silver>"
				+ "<td><h3>Power Supply</h3>"
				+ "</td>"
				+ "<td><h3></h3>"
				+ "</td>"
				+ "<td><h3>Experiments</h3>"
				+ "</td>"
				+ "</tr>"

				+ "<tr>"
				+ "<td>"
				+ "PSUTemperature: " + getStringValue("PSUTemperature", fox) + "<br>"
				+ " PSUCurrent: " + getStringValue("PSUCurrent", fox)+ "<br>"
				+ "\n"
				
				+ "</td>"
				
				+ "<td>"
				+ "</td>"
				
				+ "<td>"
				+ "EXP4Temp: " + getStringValue("EXP4Temperature", fox) + "<br>"
				+ "ExperimentFailureIndication: " + getStringValue("Experiment1FailureIndication", fox) + " "+ "<br>"
				+ getStringValue("Experiment2FailureIndication", fox) + " "+ "<br>"
				+ getStringValue("Experiment3FailureIndication", fox) + " "+ "<br>"
				+ getStringValue("Experiment4FailureIndication", fox)+ " "+ "<br>"
				+ "\n"
				
				+ "</tr>"
				
				+ "<tr bgcolor=silver>"
				+ "<td><h3>X Panels</h3>"
				+ "</td>"
				+ "<td><h3>Y Panels</h3>"
				+ "</td>"
				+ "<td><h3>Z Panels</h3>"
				+ "</td>"
				+ "</tr>"

				
				+ "<tr>"
				+ "</td>"
				+ "<td>"
				+ "PANEL_PLUS_X_V: " + getStringValue("PANEL_PLUS_X_V", fox) + "<br>"
				+ " PANEL_MINUS_X_V: " + getStringValue("PANEL_MINUS_X_V", fox)+ "<br>"
				+ "PANEL_PLUS_X_T: " + getStringValue("PANEL_PLUS_X_T", fox)+ "<br>" 
				+ " PANEL_MINUS_X_T: " + getStringValue("PANEL_MINUS_X_T", fox)+ "<br>"
				+ "SatelliteXAxisAngularVelocity: " + getStringValue("SatelliteXAxisAngularVelocity", fox) + " "+ "<br>"
				
				+ "</td>"

				+ "<td>"
				+ " PANEL_PLUS_Y_V: " + getStringValue("PANEL_PLUS_Y_V", fox)+ "<br>"
				+ " PANEL_MINUS_Y_V: " + getStringValue("PANEL_MINUS_Y_V", fox)+ "<br>"
				+ " PANEL_PLUS_Y_T: " + getStringValue("PANEL_PLUS_Y_T", fox)+ "<br>"
				+ " PANEL_MINUS_Y_T: " + getStringValue("PANEL_MINUS_Y_T", fox)+ "<br>"
				+ " SatelliteYAxisAngularVelocity: " + getStringValue("SatelliteYAxisAngularVelocity", fox)+ " "+ "<br>"
				
				+ "</td>"

				+ "<td>"
				+ " PANEL_PLUS_Z_V: " + getStringValue("PANEL_PLUS_Z_V", fox)+ "<br>"
				+ " PANEL_MINUS_Z_V: " + getStringValue("PANEL_MINUS_Z_V", fox)+ "<br>"
				+ " PANEL_PLUS_Z_T: " + getStringValue("PANEL_PLUS_Z_T", fox)+ "<br>"
				+ " PANEL_MINUS_Z_T: " + getStringValue("PANEL_MINUS_Z_T", fox)+ "<br>"
				+ " SatelliteZAxisAngularVelocity: " + getStringValue("SatelliteZAxisAngularVelocity", fox)+ " "+ "<br>"
				
				+ "</td>"

				+ "</tr>"
				
				+ "\n"
				+ "</table>";
		return s;
		
	}
	
	
	public String toString() {
		copyBitsToFields();
		String s = new String();
		s = s + "REAL TIME Telemetry:\n" 
				+ "BATT_A_V: " + FoxDecoder.dec(getRawValue("BATT_A_V")) 
				+ " BATT_B_V: " + FoxDecoder.dec(getRawValue("BATT_B_V")) 
				+ " BATT_C_V: " + FoxDecoder.dec(getRawValue("BATT_C_V"))
				+ "\n"
				+ "BATT_A_T: " + FoxDecoder.dec(getRawValue("BATT_A_T")) 
				+ " BATT_B_T: " + FoxDecoder.dec(getRawValue("BATT_B_T"))
				+ " BATT_C_T: " + FoxDecoder.dec(getRawValue("BATT_C_T"))
				+ "\n"
				+ "TOTAL_BATT_I: " + FoxDecoder.dec(getRawValue("TOTAL_BATT_I")) 
				+ " BATTBoardTemperature: " + FoxDecoder.dec(getRawValue("BATTBoardTemperature"))
				+ "\n"
				+ "PANEL_PLUS_X_V: " + FoxDecoder.dec(getRawValue("PANEL_PLUS_X_V")) 
				+ " PANEL_MINUS_X_V: " + FoxDecoder.dec(getRawValue("PANEL_MINUS_X_V"))
				+ " PANEL_PLUS_Y_V: " + FoxDecoder.dec(getRawValue("PANEL_PLUS_Y_V"))
				+ " PANEL_MINUS_Y_V: " + FoxDecoder.dec(getRawValue("PANEL_MINUS_Y_V"))
				+ " PANEL_PLUS_Z_V: " + FoxDecoder.dec(getRawValue("PANEL_PLUS_Z_V"))
				+ " PANEL_MINUS_Z_V: " + FoxDecoder.dec(getRawValue("PANEL_MINUS_Z_V"))
				+ "\n"
				+ "PANEL_PLUS_X_T: " + FoxDecoder.dec(getRawValue("PANEL_PLUS_X_T")) 
				+ " PANEL_MINUS_X_T: " + FoxDecoder.dec(getRawValue("PANEL_MINUS_X_T"))
				+ " PANEL_PLUS_Y_T: " + FoxDecoder.dec(getRawValue("PANEL_PLUS_Y_T"))
				+ " PANEL_MINUS_Y_T: " + FoxDecoder.dec(getRawValue("PANEL_MINUS_Y_T"))
				+ " PANEL_PLUS_Z_T: " + FoxDecoder.dec(getRawValue("PANEL_PLUS_Z_T"))
				+ " PANEL_MINUS_Z_T: " + FoxDecoder.dec(getRawValue("PANEL_MINUS_Z_T"))
				+ "\n"
				+ "PSUTemperature: " + FoxDecoder.dec(getRawValue("PSUTemperature")) 
				+ " SPIN: " + (getRawValue("SPIN"))
				+ "\n"
				+ "TXPACurrent: " + FoxDecoder.dec(getRawValue("TXPACurrent")) 
				+ " TXTemperature: " + FoxDecoder.dec(getRawValue("TXTemperature"))
				+ "\n"
				+ "RXTemperature: " + FoxDecoder.dec(getRawValue("RXTemperature")) 
				+ " RSSI: " + FoxDecoder.dec(getRawValue("RSSI"))
				+ "\n"
				+ "IHUTemperature: " + FoxDecoder.dec(getRawValue("IHUTemperature")) 
				+ " AntennaDeploySensors: " + (int)(getRawValue("RXAntenna")) + " "
				+ (int)(getRawValue("TXAntenna"))
				+ "\n"
				+ "SatelliteXAxisAngularVelocity: " + FoxDecoder.dec(getRawValue("SatelliteXAxisAngularVelocity")) + " "
				+ " SatelliteYAxisAngularVelocity: " + FoxDecoder.dec(getRawValue("SatelliteYAxisAngularVelocity"))+ " "
				+ " SatelliteZAxisAngularVelocity: " + FoxDecoder.dec(getRawValue("SatelliteZAxisAngularVelocity"))+ " "
				+ "\n"
				+ "EXP4Temp: " + FoxDecoder.dec(getRawValue("EXP4Temperature")) 
				+ " PSUCurrent: " + FoxDecoder.dec(getRawValue("PSUCurrent"))
				+ "\n"
				+ "IHUDiagnosticData: " + FoxDecoder.dec(getRawValue("IHUDiagnosticData"))
				+ "\n"
				+ "ExperimentFailureIndication: " + (int)(getRawValue("Experiment1FailureIndication")) + " "
				+ (int)(getRawValue("Experiment2FailureIndication")) + " "
				+ (int)(getRawValue("Experiment3FailureIndication")) + " "
				+ (int)(getRawValue("Experiment4FailureIndication"))+ " "
				+ "\n"
				+ "SystemI2CFailureIndications: " + (int)(getRawValue("BATTI2CFailureIndications")) + " "
				+ (int)(getRawValue("PSU1I2CFailureIndications")) + " "
				+ (int)(getRawValue("PSU2I2CFailureIndications")) + " "
				+ "\n"
				+ "NumberofGroundCommandedTLMResets: " + FoxDecoder.dec(getRawValue("NumberofGroundCommandedTLMResets"))
				;
		return s;
		
	}
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}


}
