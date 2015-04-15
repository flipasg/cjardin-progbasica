package crearguis;

import javax.swing.JPanel;

public class PanelBasico extends JPanel implements IGuiBasica {
    
    public PanelBasico() {
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
