import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HammDistFrame extends JFrame implements ChangeListener, ActionListener{
	private JLabel hammingDist;
	private JLabel compare;
	private JButton showStations;
	private JButton calcDist;
	private JButton addStation;
	private JSlider distSlider;
	private JTextField sliderState;
	
	private JComboBox selectStation;
	private String[] stationArray;
	
	private JTextArea distOutput;
	private JScrollPane scrollPane;
	
	private JTextField output0;
	private JTextField output1;
	private JTextField output2;
	private JTextField output3;
	private JTextField output4;
	private JLabel dist0;
	private JLabel dist1;
	private JLabel dist2;
	private JLabel dist3;
	private JLabel dist4;
	
	private JTextField addStationText;
	

	HammDistFrame()
	{
		setTitle("Hamming Distance");
		
		hammingDist = new JLabel("Enter Hamming Dist:");
		compare = new JLabel("Compare with:");
		
		showStations = new JButton("Show Station");
		showStations.addActionListener(this);
		
		calcDist = new JButton("Calculate HD");
		calcDist.addActionListener(this);
		
		addStation = new JButton("Add Station");
		addStation.addActionListener(this);
		
		dist0 = new JLabel("Distance 0");
		dist1 = new JLabel("Distance 1");
		dist2 = new JLabel("Distance 2");
		dist3 = new JLabel("Distance 3");
		dist4 = new JLabel("Distance 4");
		
		distOutput = new JTextArea(10,10);
		scrollPane = new JScrollPane(distOutput);
		distOutput.setEditable(false);		
		
		
		output0 = new JTextField(10);		
		output1 = new JTextField(10);
		output2 = new JTextField(10);
		output3 = new JTextField(10);		
		output4 = new JTextField(10);
		output0.setEditable(false);
		output1.setEditable(false);
		output2.setEditable(false);
		output3.setEditable(false);
		output4.setEditable(false);
		
		distSlider = new JSlider(1,4,1);
		distSlider.setMajorTickSpacing(1);
		distSlider.setMinorTickSpacing(1);
		distSlider.setPaintTicks(true);
		distSlider.setPaintLabels(true);
		
		distSlider.addChangeListener(this); 
		
		sliderState = new JTextField(10);
		sliderState.setText("2");
		
		addStationText = new JTextField(10);
		addStationText.setText("ZERO");
		addStationText.setEditable(true);		
		
		
		selectStation = new JComboBox(stationArray);		
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints layout = new GridBagConstraints();
		
		layout.fill = 2;
		layout.insets = new Insets(1, 10, 1, 1);
		
		layout.gridx = 0;
		layout.gridy = 0;
		add(hammingDist, layout);
		
		layout.gridx = 1;
		layout.gridy = 0;
		add(sliderState, layout);
		
		layout.gridx = 0;
		layout.gridy = 1;
		add(distSlider, layout);
		
		layout.gridx = 0;
		layout.gridy = 2;
		add(showStations, layout);
		
		layout.gridx = 0;
		layout.gridy = 3;
		add(distOutput, layout);
		
		layout.gridx = 0;
		layout.gridy = 4;
		add(compare, layout);
		
		layout.gridx = 1;
		layout.gridy = 4;
		add(selectStation, layout);
		
		layout.gridx = 0;
		layout.gridy = 5;
		add(calcDist, layout);		
		
		layout.gridx = 0;
		layout.gridy = 6;
		add(dist0, layout);
		
		layout.gridx = 1;
		layout.gridy = 6;
		add(output0, layout);
		
		layout.gridx = 0;
		layout.gridy = 7;
		add(dist1, layout);
		
		layout.gridx = 1;
		layout.gridy = 7;
		add(output1, layout);
		
		layout.gridx = 0;
		layout.gridy = 8;
		add(dist2, layout);		
		
		layout.gridx = 1;
		layout.gridy = 8;
		add(output2, layout);
	
		layout.gridx = 0;
		layout.gridy = 9;
		add(dist3, layout);
	
		layout.gridx = 1;
		layout.gridy = 9;
		add(output3, layout);
		
		layout.gridx = 0;
		layout.gridy = 10;
		add(dist4, layout);
		
		layout.gridx = 1;
		layout.gridy = 10;
		add(output4, layout);
	
		layout.gridx = 0;
		layout.gridy = 11;
		add(addStation, layout);
		
		layout.gridx = 1;
		layout.gridy = 11;
		add(addStationText, layout);
		
		
	}
	
	public void actionPerformed(ActionEvent e) { 	
		
		if(e.getSource() == calcDist){
		     
		}
		if(e.getSource() == addStation){
		      
		}
		if(e.getSource() == showStations){
		
		}
		    
	}
	
	public void stateChanged(ChangeEvent e) { 
		
		if (e.getSource() == distSlider) {
			int value = distSlider.getValue();
			sliderState.setText(Integer.toString(value));
		}
		
	}

	
	private void read()
	{
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		
		
		//skip the first three lines, unneeded info
		br.readLine();
		br.readLine();
		br.readLine();
		
		//read the next 120 lines into our locationList String array, and shorten them to the 4 character location
		for(int i = 0; i < 120; i++) 
		{
			stationArray[i] = br.readLine().substring(1, 5);
		}
		
		br.close();		
	}
	
}
