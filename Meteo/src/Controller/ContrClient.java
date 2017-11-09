package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import VIEW.FinestraMeteo;
public class ContrClient implements ActionListener,ChangeListener{
	private FinestraMeteo f;
	public ContrClient(FinestraMeteo f){
		this.f=f;
		f.getBtnInvia().addActionListener(this);
		f.getTabbedPane().addChangeListener(this);
	}
	private void inviaDati(String s){
		
	}
	@Override
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource()==f.getBtnInvia()){
			this.inviaDati(f.getTextField().getText());
			f.getTextField().setText("");
		}
		else{
		}
	}
	@Override
	public void stateChanged(ChangeEvent evt){
		switch(f.getTabbedPane().getSelectedIndex()){
			case 0: f.getTextField().setText("");
			break;
			case 1:
		}
	}
}