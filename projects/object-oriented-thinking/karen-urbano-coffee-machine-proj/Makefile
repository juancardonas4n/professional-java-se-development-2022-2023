all: Coffee_Vending_Machine_app.pdf

Coffee_Vending_Machine_app.pdf: Coffee_Vending_Machine_app.docx
	pandoc $^ --output=$@

clean:
	rm -f Coffee_Vending_Machine_app.pdf
