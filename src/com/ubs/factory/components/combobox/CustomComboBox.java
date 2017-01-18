package com.ubs.factory.components.combobox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import com.ubs.factory.components.CustomComponent;
import com.ubs.factory.controller.FormOptions;
import com.ubs.factory.gui.AutoForm;

@SuppressWarnings("rawtypes")
public class CustomComboBox extends CustomComponent<JComboBox> implements ItemListener {
	
	@SuppressWarnings("unchecked")
	public CustomComboBox(FormOptions opts, AutoForm form) {
		super(opts, form, opts.getValidator());
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add("Bitte auswählen");
		
		for(Object o : ((ComboSettings)options.getSettings()).getObjects()) {
			list.add(o);
		}
		
		setComponent(new JComboBox(list.toArray()));
		
		getComponent().addItemListener(this);
		
		verify();
	}

	@Override
	public Object getValue() {
		return getComponent().getSelectedItem();
	}

	@Override
	public void clear() {
		getComponent().setSelectedIndex(0);
	}

	@Override
	public boolean isNull() {
		boolean nil = getComponent().getSelectedIndex() == 0;
		return nil;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		verify();
	}

}