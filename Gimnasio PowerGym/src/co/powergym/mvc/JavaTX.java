package co.powergym.mvc;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;

import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class JavaTX extends javax.swing.JFrame {

    public static void main(String[] args) {
		abrirTorniquete(false);
	}
    public static void abrirTorniquete(boolean opcion) {
	    PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
	    try {
            //Se inicia la comunicación con el Puerto Serie
            ino.arduinoTX("COM5", 9600);
            TimeUnit.SECONDS.sleep(2);
            ino.sendData("1");
        } catch (ArduinoException ex) {
            Logger.getLogger(JavaTX.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
