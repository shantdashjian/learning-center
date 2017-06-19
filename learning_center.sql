-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema learning_center
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `learning_center` ;

-- -----------------------------------------------------
-- Schema learning_center
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `learning_center` DEFAULT CHARACTER SET utf8 ;
USE `learning_center` ;

-- -----------------------------------------------------
-- Table `learning_center`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `learning_center`.`user` ;

CREATE TABLE IF NOT EXISTS `learning_center`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `learning_center`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `learning_center`.`course` ;

CREATE TABLE IF NOT EXISTS `learning_center`.`course` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `learning_center`.`course_enrollment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `learning_center`.`course_enrollment` ;

CREATE TABLE IF NOT EXISTS `learning_center`.`course_enrollment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `next_step_no` INT(11) NOT NULL DEFAULT 0,
  `progress` INT(11) NOT NULL DEFAULT 0,
  `date_started` TIMESTAMP(4) NOT NULL DEFAULT CURRENT_TIMESTAMP(4),
  `course_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_course_progress_course_idx` (`course_id` ASC),
  INDEX `fk_course_progress_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_course_enrollment_course`
    FOREIGN KEY (`course_id`)
    REFERENCES `learning_center`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_enrollment_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `learning_center`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `learning_center`.`step`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `learning_center`.`step` ;

CREATE TABLE IF NOT EXISTS `learning_center`.`step` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `step_no` INT(11) NOT NULL DEFAULT 0,
  `title` VARCHAR(255) NOT NULL,
  `description` TEXT NOT NULL,
  `image_url` TEXT NOT NULL,
  `question` TEXT NOT NULL,
  `answer` VARCHAR(1) NOT NULL DEFAULT 'A',
  `course_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_step_course1_idx` (`course_id` ASC),
  CONSTRAINT `fk_step_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `learning_center`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO lc_user@localhost;
 DROP USER lc_user@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'lc_user'@'localhost' IDENTIFIED BY 'lc_user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `learning_center`.* TO 'lc_user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `learning_center`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `learning_center`;
INSERT INTO `learning_center`.`user` (`id`, `email`, `password`) VALUES (1, 'student@theceshop.com', '$2a$10$8oZQ4rw5wmao07yXcjTTeevRBWBRCNiEyHY57oWBq53Wtjyz360S6');

COMMIT;


-- -----------------------------------------------------
-- Data for table `learning_center`.`course`
-- -----------------------------------------------------
START TRANSACTION;
USE `learning_center`;
INSERT INTO `learning_center`.`course` (`id`, `name`) VALUES (1, 'Real Estate Concepts: Part 1');
INSERT INTO `learning_center`.`course` (`id`, `name`) VALUES (2, 'Real Estate Concepts: Part 2');

COMMIT;


-- -----------------------------------------------------
-- Data for table `learning_center`.`course_enrollment`
-- -----------------------------------------------------
START TRANSACTION;
USE `learning_center`;
INSERT INTO `learning_center`.`course_enrollment` (`id`, `next_step_no`, `progress`, `date_started`, `course_id`, `user_id`) VALUES (1, 1, 0, '2017-06-18 00:00:00', 1, 1);
INSERT INTO `learning_center`.`course_enrollment` (`id`, `next_step_no`, `progress`, `date_started`, `course_id`, `user_id`) VALUES (2, 5, 40, '2017-06-18 00:00:00', 2, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `learning_center`.`step`
-- -----------------------------------------------------
START TRANSACTION;
USE `learning_center`;
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (1, 1, 'Acceleration Clause', 'A clause in your mortgage which allows the lender to demand payment of the outstanding loan balance for various reasons. The most common reasons for accelerating a loan are if the borrower defaults on the loan or transfers title to another individual without informing the lender.', 'http://notequeen.com/wp-content/uploads/sites/45/2008/11/halloween.jpg', 'The acceleration clause allows the lender to demand payment.', 'A', 1);
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (2, 2, 'Adjustable-Rate Mortgage (ARM)', 'A mortgage in which the interest changes periodically, according to corresponding fluctuations in an index. All ARMs are tied to indexes.', 'http://www.themoneyalert.com/images/Adjustable_Rate_Mortgage.jpg', 'Interest in ARM changes periodically.', 'A', 1);
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (3, 3, 'Adjustment Date', 'The date the interest rate changes on an adjustable-rate mortgage.', 'https://loanscanada.ca/wp-content/uploads/2016/08/interest-adjustment.jpg', 'Adjustment date is the date the initial value of a mortgage changes.', 'B', 1);
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (4, 1, 'Amortization', 'The loan payment consists of a portion which will be applied to pay the accruing interest on a loan, with the remainder being applied to the principal. Over time, the interest portion decreases as the loan balance decreases, and the amount applied to principal increases so that the loan is paid off (amortized) in the specified time.', 'http://www.mathcorp.com/images/loan-amortization-schedule.jpg', 'Over time, the interest portion decreases as the loan balance decreases.', 'A', 2);
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (5, 2, 'Amortization Schedule', 'A table which shows how much of each payment will be applied toward principal and how much toward interest over the life of the loan. It also shows the gradual decrease of the loan balance until it reaches zero.', 'https://financialmentor.com/wp-content/uploads/amortization-schedule-calculator-1024x683.jpg', 'An amortization schedule shows how much of each payment will be applied toward principal.', 'A', 2);
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (6, 3, 'Annual Percentage Rate (APR)', 'This is not the note rate on your loan. It is a value created according to a government formula intended to reflect the true annual cost of borrowing, expressed as a percentage. It works sort of like this, but not exactly, so only use this as a guideline: deduct the closing costs from your loan amount, then using your actual loan payment, calculate what the interest rate would be on this amount instead of your actual loan amount. You will come up with a number close to the APR. Because you are using the same payment on a smaller amount, the APR is always higher than the actual note rate on your loan.', 'http://www.92101urbanliving.com/wp-content/uploads/2012/10/interest-rate.jpg', 'The APR is not always higher than the actual note rate on your loan.', 'B', 2);
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (7, 4, 'Application', 'The form used to apply for a mortgage loan, containing information about a borrower\'s income, savings, assets, debts, and more.', 'http://us.res.keymedia.com/files/image/mortgageapplication.jpg', 'An application is a form used to apply for a mortgage loan.', 'A', 2);
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (8, 5, 'Appraisal', 'A written justification of the price paid for a property, primarily based on an analysis of comparable sales of similar homes nearby.', 'http://etowahcounty.churchwebfuel.com/wp-content/uploads/sites/185/2016/02/appraisal.jpg', 'An appraisal is a verbal justification of the price paid for a property.', 'B', 2);
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (9, 6, 'Appraised Value', 'An opinion of a property\'s fair market value, based on an appraiser\'s knowledge, experience, and analysis of the property. Since an appraisal is based primarily on comparable sales, and the most recent sale is the one on the property in question, the appraisal usually comes out at the purchase price.', 'http://coldwellbankergoldendale.com/images/site_graphics/appraisal_img.jpg', 'Since an appraisal is based primarily on comparable sales, and the most recent sale is the one on the property in question, the appraisal usually comes out at the purchase price.', 'A', 2);
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (10, 7, 'Appraiser', 'An individual qualified by education, training, and experience to estimate the value of real property and personal property. Although some appraisers work directly for mortgage lenders, most are independent.', 'http://birminghamappraisalblog.com/wp-content/uploads/2011/07/BirminghamAL-Home-Appraiser-300x273.jpg', 'Appraisers can be independent.', 'A', 2);
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (11, 8, 'Appreciation', 'The increase in the value of a property due to changes in market conditions, inflation, or other causes.', 'https://employmentmattersblog.mintzlevinblogs.com/wp-content/uploads/sites/5/2015/03/Employee-Appreciation-Day.jpg', 'Appreciation is the increase in the value of a property due to changes in market conditions, inflation, or other causes.', 'A', 2);
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (12, 9, 'Assessed Value', 'The valuation placed on property by a public tax assessor for purposes of taxation.', 'https://www.wycokck.org/uploadedImages/Departments/Treasury/Assessed%20Value.jpg', 'Assessed Value is for taxation.', 'A', 2);
INSERT INTO `learning_center`.`step` (`id`, `step_no`, `title`, `description`, `image_url`, `question`, `answer`, `course_id`) VALUES (13, 10, 'Assessment', 'The placing of a value on property for the purpose of taxation.', 'http://funderstanding.com/wp-content/uploads/2011/04/classroom-assessment.jpg', 'Assessment is the placing of a value on property for the purpose of taxation.', 'A', 2);

COMMIT;

