package com.fatuma.Travelnow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatuma.Travelnow.models.SaveTravelModel;
import com.fatuma.Travelnow.services.SaveTravelService;

@RestController
@RequestMapping("/api")
// ==============API BACK END =====================
public class APISaveTravelController {
	@Autowired
	private SaveTravelService tsService;
	
	// ===================== Get ALl ======================
	
	@GetMapping("/travel")
	public List<SaveTravelModel> getAll(){
		return this.tsService.getAll();
		
	}
	
	// ==================== CREATE==========================
	
	@PostMapping("/create")
	public SaveTravelModel createSaveTravel(
			@RequestParam("name")String name,
			@RequestParam("vendor")String vendor,
			@RequestParam("amount") Integer amount,
			@RequestParam("description") String desc) {
		// save this data we created
		
		SaveTravelModel newSaveTravel = new SaveTravelModel(name,vendor,amount,desc);
		
		return this.tsService.create(newSaveTravel);
		
	}
	
	//=================== Read by ID ======================
	// SaveTravelModel this data type we want to iterate to and get from 
	
	@GetMapping("/{stravelID}")
	public SaveTravelModel getOne(@PathVariable("stravelID")Long idDelete) {
		return this.tsService.getById(idDelete);
	}
	
	// ====================== UPDATE===================================
	@PostMapping("/update/{stravelID}")
	public String updateThisObject(@PathVariable("stravelID")Long updateID,
			@RequestParam(value="name",required= false)String name,
			@RequestParam(value="vendor")String vendor,
			@RequestParam(value ="amount")Integer amount,
			@RequestParam(value="description")String desc) {
		// save the new update value 
		SaveTravelModel updatedTravel = tsService.getById(updateID);
		// setting the new object to new value
		
		updatedTravel.setExpenseName(name !=null? name: updatedTravel.getExpenseName());
		
		updatedTravel.setVendor( vendor!=null? vendor: updatedTravel.getVendor());
		updatedTravel.setDescription(desc !=null? desc:updatedTravel.getDescription());
		updatedTravel.setAmount(amount);
		// save this new object we have created
		
		this.tsService.update(updatedTravel);
		return "";
		
	}
	
	// =================== DELETE BY ID ============================
//		@DeleteMapping("/delete/{stravelId}")
//		public void deleteObject(@PathVariable("straveltId")Long idDelete) {
//			System.out.print(idDelete);
//			this.tsService.delete(idDelete);
////			return "";
//		}
	
	 @DeleteMapping("/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
		 tsService.delete(id);
		 System.out.println(id);
	        return "";
	    }

		//======================== EDIT ========================
				// since we going to get 
				@GetMapping("/edit/{tweetId}")
				public String editRender() {
					return "";
				}
}
			

