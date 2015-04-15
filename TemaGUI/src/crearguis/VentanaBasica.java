package crearguis;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class VentanaBasica extends JFrame implements IGuiBasica {
    
    

    public VentanaBasica(String title) throws HeadlessException {
	super(title);
	iniciar();
    }
    
    public void iniciar() {
	instanciar();
	configurar();
	aniadir();
	oyentes();
	propFinales();
    }

    @Override
    public void instanciar() {}

    @Override
    public void configurar() {}

    @Override
    public void aniadir() {}

    @Override
    public void oyentes() {}

    @Override
    public void propFinales() {}
    
}
