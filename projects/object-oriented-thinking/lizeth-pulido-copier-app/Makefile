all: A_copier_at_a_university.pdf

A_copier_at_a_university.pdf: A_copier_at_a_university.docx
	pandoc $^ --output=$@

clean:
	rm -f A_copier_at_a_university.pdf
