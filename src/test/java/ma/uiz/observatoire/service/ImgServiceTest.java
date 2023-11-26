package ma.uiz.observatoire.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.persistence.EntityNotFoundException;
import ma.uiz.observatoire.utils.ImgUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ImgService.class})
@ExtendWith(SpringExtension.class)
class ImgServiceTest {
  @Autowired
  private ImgService imgService;

  @MockBean
  private ImgUtils imgUtils;
  /**
  * Method under test: {@link ImgService#getImage(String)}
  */
  @Test
  void testGetImage() {
    // Arrange
    when(imgUtils.getFileSystemFolder()).thenReturn("File System Folder");

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> imgService.getImage("Img"));
    verify(imgUtils).getFileSystemFolder();
  }

  /**
   * Method under test: {@link ImgService#getImage(String)}
   */
  @Test
  void testGetImage2() {
    // Arrange
    when(imgUtils.getFileSystemFolder()).thenThrow(new EntityNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> imgService.getImage("Img"));
    verify(imgUtils).getFileSystemFolder();
  }
}

