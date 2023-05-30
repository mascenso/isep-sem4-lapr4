package eCourse.studentusermanagement.domain;

import eapli.framework.domain.model.ValueObject;

public class TaxPayNumber implements ValueObject, Comparable<TaxPayNumber>{

    private Long taxpaynumber;

    public TaxPayNumber(final String taxPayerNumber) {
        checkTaxPayerNumber(taxPayerNumber);
        this.taxpaynumber = Long.parseLong(taxPayerNumber);
    }

    protected TaxPayNumber() {
        // for ORM
    }

    public static TaxPayNumber valueOf(final String taxPayerNumber) {
        return new TaxPayNumber(taxPayerNumber);
    }

    /**
     * Portuguese Tax Payer Number has 9 digits
     */
    private void checkTaxPayerNumber(String taxPayerNumber) {
        if (taxPayerNumber == null || taxPayerNumber.isEmpty()) {
            throw new IllegalArgumentException(
                    "Tax Payer Number should neither be null nor empty");
        }
        else if ( taxPayerNumber.length() != 9)
            throw new IllegalArgumentException(
                    "Tax Payer Number should have 9 digits");
    }

    @Override
    public int compareTo(TaxPayNumber o) {
        return 0;
    }

}
