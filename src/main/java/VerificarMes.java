
public class VerificarMes {

	private int click;

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public void verificandoMes(String mes) {

		if (mes == "DEZEMBRO 2021") {

			this.click = 4;

		} else if (mes == "JANEIRO 2022") {

			this.click = 3;

		} else if (mes == "FEVEREIRO 2022") {

			this.click = 2;

		} else if (mes == "MARÇO 2022") {

			this.click = 1;

		}
	}
}
