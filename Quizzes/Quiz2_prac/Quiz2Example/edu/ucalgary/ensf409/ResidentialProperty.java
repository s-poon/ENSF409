/*
Copyright Ann Barcomb and Emily Marasco, 2022
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

/**
 * Class which describes a residential property in Calgary
**/

package edu.ucalgary.ensf409;

public class ResidentialProperty extends CalgaryProperty {
    private String description = "apartment";

    /** Constructors **/
    public ResidentialProperty(int taxRollNumber, String streetName, int buildingNumber, String postCode, String description) throws IllegalArgumentException {
        super(taxRollNumber, "RESIDENTIAL", streetName, buildingNumber, postCode);
        this.description = description;
    }

    public ResidentialProperty(String description, int taxRollNumber, String streetName, int buildingNumber, String postCode, String annex){
        super(taxRollNumber, "RESIDENTIAL", streetName, buildingNumber, postCode, annex);
        this.description = description;
    }

    public ResidentialProperty(String description, int taxRollNumber, String streetName, int buildingNumber, String postCode){
        super(taxRollNumber, "RESIDENTIAL", streetName, buildingNumber, postCode);
        this.description = description;
    }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }

    public String formatOutput() {
        StringBuilder output = new StringBuilder();
        StandardFormatting standard = new StandardFormatting();
        String address = this.buildingNumber + " " + this.streetName;
        output.append(standard.formatOutput("Description", this.description) + "\n");
        output.append(standard.formatOutput("Address", address) + "\n");
        if(this.getBuildingAnnex() != null){
            output.append(this.getBuildingAnnex() + "\n");
        }
        output.append(standard.formatOutput("Postcode", this.postCode) + "\n");
        return output.toString(); 
    }

    public String formatOutput(String key, String value) {
        StringBuilder output = new StringBuilder();
        String address = key + ":\t\t" + value;
        StandardFormatting standard = new StandardFormatting();
        output.append(standard.formatOutput("Description", this.description) + "\n");
        output.append(standard.formatOutput("Address", address) + "\n");
        output.append(standard.formatOutput("PostCode", this.postCode) + "\n");
        return address; 
    }
}
